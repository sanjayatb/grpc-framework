package com.stb.grpc.client.model;

public class ResponseStatus {
    private final StatusCode statusCode;
    private final String description;

    public StatusCode getStatusCode() {
        return statusCode;
    }

    public String getDescription() {
        return description;
    }

    private ResponseStatus(Builder builder) {
        this.statusCode = builder.statusCode;
        this.description = builder.description;
    }

    public static class Builder {
        private StatusCode statusCode;
        private String description;

        public Builder setStatusCode(StatusCode statusCode) {
            this.statusCode = statusCode;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public ResponseStatus build() {return new ResponseStatus(this);}
    }

}
