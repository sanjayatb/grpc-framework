package com.stb.grpc.config;

import io.grpc.ServerBuilder;
import org.lognet.springboot.grpc.GRpcServerBuilderConfigurer;

public class GenericServerBuilderConfigure extends GRpcServerBuilderConfigurer {

    @Override
    public void configure(ServerBuilder<?> serverBuilder){

    }


}
