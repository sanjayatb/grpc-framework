package com.stb.grpc.client.channel;

public interface Channel<T> {
    T getChannel();

    Long getDuration();

}
