package com.stb.grpc.client.exceptions;

public class AdaptorException extends Exception{

    public AdaptorException(Exception e){
        super(e);
    }

    public AdaptorException(String message){
        super(message);
    }

}
