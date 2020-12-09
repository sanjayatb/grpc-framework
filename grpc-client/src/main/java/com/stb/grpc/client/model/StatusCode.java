package com.stb.grpc.client.model;

public enum StatusCode {

    UNKNOWN(0),
    OK(200),
    NOT_FOUND(404),
    NO_CONTENT(204),
    INVALID_REQUEST(400),
    UNAUTHORIZED(401),
    INTERNAL_SERVER_ERROR(500);

    private final int value;

    StatusCode(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
