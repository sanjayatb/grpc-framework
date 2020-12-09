package com.stb.grpc.client.model;

import com.stb.grpc.model.MessageType;

public class GenericResponse {

    private MessageType messageType;
    private byte[] payload;
    ResponseStatus responseStatus;

    private GenericResponse(Builder builder){
        messageType = builder.messageType;
        payload = builder.payload;
        responseStatus = builder.responseStatus;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public byte[] getPayload() {
        return payload;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public static class Builder{
        private MessageType messageType;
        private byte[] payload;
        private ResponseStatus responseStatus;

        public Builder setMessageType(MessageType messageType) {
            this.messageType = messageType;
            return this;
        }

        public Builder setPayload(byte[] payload) {
            this.payload = payload;
            return this;
        }

        public Builder setResponseStatus(ResponseStatus responseStatus) {
            this.responseStatus = responseStatus;
            return this;
        }

        private void checkValues(GenericResponse request){
            if(null == request.getMessageType()){
                throw new IllegalArgumentException("Message Type not defined");
            }
        }

        public GenericResponse build(){
            GenericResponse request = new GenericResponse(this);
            checkValues(request);
            return request;
        }
    }

}
