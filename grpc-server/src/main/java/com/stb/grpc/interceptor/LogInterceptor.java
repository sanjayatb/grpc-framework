package com.stb.grpc.interceptor;

import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("logInterceptor")
public class LogInterceptor implements ServerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogInterceptor.class);

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> serverCall, Metadata metadata, ServerCallHandler<ReqT, RespT> serverCallHandler) {
        LOGGER.info("method = {}, attributes = {},  headers = {}",serverCall.getMethodDescriptor().getFullMethodName(),serverCall.getAttributes(),metadata);
        return serverCallHandler.startCall(serverCall,metadata);
    }
}
