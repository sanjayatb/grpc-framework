package com.stb.grpc.client.builder;

import com.stb.grpc.client.model.GenericResponse;
import com.stb.grpc.client.model.ResponseStatus;
import com.stb.grpc.client.model.StatusCode;
import com.stb.grpc.model.MessageType;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;

public class ResponseBuilder {

    public static GenericResponse generateResponse(MessageType messageType, byte[] payload, ResponseStatus status){
        return new GenericResponse
                .Builder()
                .setMessageType(messageType)
                .setPayload(payload)
                .setResponseStatus(status)
                .build();
    }

    public static ResponseStatus generateResponseStatus(String message,StatusCode statusCode){
        return new ResponseStatus.Builder()
                .setStatusCode(statusCode)
                .setDescription(message)
                .build();
    }


    public static ResponseStatus generateResponseStatus(Exception e, StatusCode statusCode){
        StatusCode tmpStatus= statusCode;
        StatusRuntimeException sre = null;
        if(e instanceof StatusRuntimeException){
            sre = (StatusRuntimeException)e;
        }

        String description = e.getMessage();

        if(null != sre &&
                sre.getStatus().getCode().value() == Status.PERMISSION_DENIED.getCode().value()){
            tmpStatus = StatusCode.UNAUTHORIZED;
            description = "User have no permission to invoke this service";
        }

        return new ResponseStatus.Builder()
                .setStatusCode(tmpStatus)
                .setDescription(description)
                .build();
    }


}
