package com.stb.grpc.client.adaptor;

import com.stb.grpc.client.builder.ResponseBuilder;
import com.stb.grpc.client.exceptions.AdaptorException;
import com.stb.grpc.client.model.GenericResponse;
import com.stb.grpc.client.model.ResponseStatus;
import com.stb.grpc.model.GenericResponseProto;

import java.util.Objects;

public class ResponseAdaptor implements Adaptor<GenericResponseProto, GenericResponse> {

    @Override
    public GenericResponse convert(GenericResponseProto input) throws AdaptorException {
        if(Objects.isNull(input)){
            throw new AdaptorException("Request is null");
        }

        ResponseStatus status = new ResponseStatusAdaptor().convert(input.getResponseStatus());
        GenericResponse response = ResponseBuilder
                .generateResponse(input.getMessageType(),input.getPayload().toByteArray(),status);
        return response;
    }
}
