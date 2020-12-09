package com.stb.grpc.client.channel;

public class InProcessChannel implements Channel<ManagedChannel> {

    @Override
    public ManagedChannel getChannel() {
        return null;
    }

    @Override
    public Long getDuration() {
        return null;
    }
}
