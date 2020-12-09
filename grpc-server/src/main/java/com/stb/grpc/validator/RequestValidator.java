package com.stb.grpc.validator;

import io.grpc.Context;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Component;

@Component
public class RequestValidator {

    public boolean hasClientCancelled(StreamObserver responseObserver){
        if(Context.current().isCancelled()){
            responseObserver.onError(Status.CANCELLED.withDescription("Cancled by Client").asRuntimeException());
            return true;
        }
        return false;
    }

}
