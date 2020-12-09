package com.stb.grpc.model;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.34.0)",
    comments = "Source: generic-service.proto")
public final class GrpcGenericServiceGrpc {

  private GrpcGenericServiceGrpc() {}

  public static final String SERVICE_NAME = "com.stb.grpc.GrpcGenericService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.stb.grpc.model.GenericRequestProto,
      com.stb.grpc.model.GenericResponseProto> getGetResponseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getResponse",
      requestType = com.stb.grpc.model.GenericRequestProto.class,
      responseType = com.stb.grpc.model.GenericResponseProto.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.stb.grpc.model.GenericRequestProto,
      com.stb.grpc.model.GenericResponseProto> getGetResponseMethod() {
    io.grpc.MethodDescriptor<com.stb.grpc.model.GenericRequestProto, com.stb.grpc.model.GenericResponseProto> getGetResponseMethod;
    if ((getGetResponseMethod = GrpcGenericServiceGrpc.getGetResponseMethod) == null) {
      synchronized (GrpcGenericServiceGrpc.class) {
        if ((getGetResponseMethod = GrpcGenericServiceGrpc.getGetResponseMethod) == null) {
          GrpcGenericServiceGrpc.getGetResponseMethod = getGetResponseMethod =
              io.grpc.MethodDescriptor.<com.stb.grpc.model.GenericRequestProto, com.stb.grpc.model.GenericResponseProto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getResponse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.stb.grpc.model.GenericRequestProto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.stb.grpc.model.GenericResponseProto.getDefaultInstance()))
              .setSchemaDescriptor(new GrpcGenericServiceMethodDescriptorSupplier("getResponse"))
              .build();
        }
      }
    }
    return getGetResponseMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GrpcGenericServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GrpcGenericServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GrpcGenericServiceStub>() {
        @java.lang.Override
        public GrpcGenericServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GrpcGenericServiceStub(channel, callOptions);
        }
      };
    return GrpcGenericServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GrpcGenericServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GrpcGenericServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GrpcGenericServiceBlockingStub>() {
        @java.lang.Override
        public GrpcGenericServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GrpcGenericServiceBlockingStub(channel, callOptions);
        }
      };
    return GrpcGenericServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GrpcGenericServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GrpcGenericServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GrpcGenericServiceFutureStub>() {
        @java.lang.Override
        public GrpcGenericServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GrpcGenericServiceFutureStub(channel, callOptions);
        }
      };
    return GrpcGenericServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class GrpcGenericServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getResponse(com.stb.grpc.model.GenericRequestProto request,
        io.grpc.stub.StreamObserver<com.stb.grpc.model.GenericResponseProto> responseObserver) {
      asyncUnimplementedUnaryCall(getGetResponseMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetResponseMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.stb.grpc.model.GenericRequestProto,
                com.stb.grpc.model.GenericResponseProto>(
                  this, METHODID_GET_RESPONSE)))
          .build();
    }
  }

  /**
   */
  public static final class GrpcGenericServiceStub extends io.grpc.stub.AbstractAsyncStub<GrpcGenericServiceStub> {
    private GrpcGenericServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GrpcGenericServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GrpcGenericServiceStub(channel, callOptions);
    }

    /**
     */
    public void getResponse(com.stb.grpc.model.GenericRequestProto request,
        io.grpc.stub.StreamObserver<com.stb.grpc.model.GenericResponseProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetResponseMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class GrpcGenericServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<GrpcGenericServiceBlockingStub> {
    private GrpcGenericServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GrpcGenericServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GrpcGenericServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.stb.grpc.model.GenericResponseProto getResponse(com.stb.grpc.model.GenericRequestProto request) {
      return blockingUnaryCall(
          getChannel(), getGetResponseMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class GrpcGenericServiceFutureStub extends io.grpc.stub.AbstractFutureStub<GrpcGenericServiceFutureStub> {
    private GrpcGenericServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GrpcGenericServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GrpcGenericServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.stb.grpc.model.GenericResponseProto> getResponse(
        com.stb.grpc.model.GenericRequestProto request) {
      return futureUnaryCall(
          getChannel().newCall(getGetResponseMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_RESPONSE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GrpcGenericServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GrpcGenericServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_RESPONSE:
          serviceImpl.getResponse((com.stb.grpc.model.GenericRequestProto) request,
              (io.grpc.stub.StreamObserver<com.stb.grpc.model.GenericResponseProto>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class GrpcGenericServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GrpcGenericServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.stb.grpc.model.GenericServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GrpcGenericService");
    }
  }

  private static final class GrpcGenericServiceFileDescriptorSupplier
      extends GrpcGenericServiceBaseDescriptorSupplier {
    GrpcGenericServiceFileDescriptorSupplier() {}
  }

  private static final class GrpcGenericServiceMethodDescriptorSupplier
      extends GrpcGenericServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GrpcGenericServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (GrpcGenericServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GrpcGenericServiceFileDescriptorSupplier())
              .addMethod(getGetResponseMethod())
              .build();
        }
      }
    }
    return result;
  }
}
