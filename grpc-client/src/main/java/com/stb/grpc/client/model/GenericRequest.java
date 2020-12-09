package com.stb.grpc.client.model;

import com.stb.grpc.model.MessageType;

public class GenericRequest {

    private MessageType messageType;
    private byte[] payload;

    public MessageType getMessageType() {
        return messageType;
    }

    public byte[] getPayload() {
        return payload;
    }

    private GenericRequest(Builder builder){
        messageType = builder.messageType;
        payload = builder.payload;
    }

    public static class Builder{
        private MessageType messageType;
        private byte[] payload;

        public Builder setMessageType(MessageType messageType) {
            this.messageType = messageType;
            return this;
        }

        public Builder setPayload(byte[] payload) {
            this.payload = payload;
            return this;
        }

        private void checkValues(GenericRequest request){
            if(null == request.getMessageType()){
                throw new IllegalArgumentException("Message Type not defined");
            }
        }

        public GenericRequest build(){
            GenericRequest request = new GenericRequest(this);
            checkValues(request);
            return request;
        }
    }

}
