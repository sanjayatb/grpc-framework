package com.stb.grpc.client.adaptor;

import com.stb.grpc.client.exceptions.AdaptorException;

@FunctionalInterface
public interface Adaptor<I,O> {
    O convert(I input) throws AdaptorException;
}
