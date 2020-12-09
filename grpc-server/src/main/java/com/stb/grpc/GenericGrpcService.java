package com.stb.grpc;


import com.google.protobuf.ByteString;
import com.stb.grpc.common.ResponseStatusProto;
import com.stb.grpc.common.StatusCodeProto;
import com.stb.grpc.model.GenericRequestProto;
import com.stb.grpc.model.GenericResponseProto;
import com.stb.grpc.model.GrpcGenericServiceGrpc;
import com.stb.grpc.model.MessageType;
import com.stb.grpc.validator.RequestValidator;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.EnumMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.UnaryOperator;

@GRpcService
public class GenericGrpcService extends GrpcGenericServiceGrpc.GrpcGenericServiceImplBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(GenericGrpcService.class);
    private AtomicInteger messageCount = new AtomicInteger(0);

    @Autowired
    private RequestValidator validator;

    private Map<MessageType, UnaryOperator<byte[]>> transformFunctions = new EnumMap<>(MessageType.class);

    public void setTransformFunctions(Map<MessageType, UnaryOperator<byte[]>> transformFunctions) {
        this.transformFunctions = transformFunctions;
    }

    @Override
    public void getResponse(GenericRequestProto request, StreamObserver<GenericResponseProto> responseObserver) {

        LOGGER.info("Request received. [id={}] [messageType={}]", messageCount.addAndGet(1), request.getMessageType());

        if (validator.hasClientCancelled(responseObserver)) {
            LOGGER.warn("Client has canceled the request. [{}]", request);
            return;
        }

        if (!transformFunctions.containsKey(request.getMessageType())) {
            throw new IllegalArgumentException("Transformation function not defined for [" +
                    request.getMessageType().getValueDescriptor().getName() + "]");
        }

        GenericResponseProto.Builder responseBuilder = GenericResponseProto.newBuilder();
        responseBuilder.setMessageType(request.getMessageType());
        ResponseStatusProto.Builder statusBuider = ResponseStatusProto.newBuilder();
        String hostName = getRunningServer();
        String description = "[server=]" + hostName + "]";

        byte[] response = "".getBytes();
        try {
            response = transformFunctions.get(request.getMessageType())
                    .apply(request.getPayload().toByteArray());
            responseBuilder.setPayload(ByteString.copyFrom(response));

            statusBuider.setCode(StatusCodeProto.OK);
        } catch (Exception e) {
            statusBuider.setCode(StatusCodeProto.INTERNAL_SERVER_ERROR);
            description += " | " + e.getMessage();
            LOGGER.error("Exception occurs while getting response: {}", e.getMessage(), e);
        }

        statusBuider.setDescription(description);

        responseBuilder.setResponseStatus(statusBuider.build());

        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();
        String responseStr = new String(response);
        LOGGER.info("Response Sent. [id={}] [messageType={}] [message={}]", messageCount.get(), request.getMessageType(), responseStr);
    }

    private String getRunningServer() {
        String hostname = "unknown";
        try {
            hostname = InetAddress.getLocalHost().getHostName();
            LOGGER.info("Running in : {}", hostname);
        } catch (UnknownHostException e) {
           LOGGER.warn("Unknown host",e);
        }
        return hostname;
    }


}
