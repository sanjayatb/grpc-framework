package com.stb.grpc.client.adaptor;

import com.google.protobuf.ByteString;
import com.stb.grpc.client.exceptions.AdaptorException;
import com.stb.grpc.client.model.GenericRequest;
import com.stb.grpc.model.GenericRequestProto;

import java.util.Objects;

public class RequestAdaptor implements Adaptor<GenericRequest, GenericRequestProto> {

    @Override
    public GenericRequestProto convert(GenericRequest input) throws AdaptorException {
        if(Objects.isNull(input)){
            throw new AdaptorException("Request is null");
        }
        if(null == input.getPayload()){
            throw new AdaptorException("Payload is null");
        }
        return GenericRequestProto.newBuilder()
                .setMessageType(input.getMessageType())
                .setPayload(ByteString.copyFrom(input.getPayload()))
                .build();
    }
}
