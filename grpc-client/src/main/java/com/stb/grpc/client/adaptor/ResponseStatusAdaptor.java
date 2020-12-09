package com.stb.grpc.client.adaptor;

import com.stb.grpc.client.exceptions.AdaptorException;
import com.stb.grpc.client.model.ResponseStatus;
import com.stb.grpc.client.model.StatusCode;
import com.stb.grpc.common.ResponseStatusProto;

public class ResponseStatusAdaptor implements Adaptor<ResponseStatusProto, ResponseStatus> {

    @Override
    public ResponseStatus convert(ResponseStatusProto input) throws AdaptorException {
        return new ResponseStatus.Builder()
                .setDescription(input.getDescription())
                .setStatusCode(StatusCode.valueOf(input.getCode().name()))
                .build();
    }
}
