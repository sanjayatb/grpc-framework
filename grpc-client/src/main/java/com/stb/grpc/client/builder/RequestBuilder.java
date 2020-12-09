package com.stb.grpc.client.builder;

import com.stb.grpc.client.model.GenericRequest;
import com.stb.grpc.model.MessageType;

public class RequestBuilder {

    private RequestBuilder(){}

    public static GenericRequest generateRequest(MessageType messageType,byte[] payload){
        return new GenericRequest
                .Builder()
                .setMessageType(messageType)
                .setPayload(payload)
                .build();
    }

}
