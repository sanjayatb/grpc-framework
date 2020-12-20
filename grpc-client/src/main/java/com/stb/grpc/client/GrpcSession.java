package com.stb.grpc.client;

import com.stb.grpc.client.channel.Channel;
import com.stb.grpc.client.channel.LoadBalanceType;
import com.stb.grpc.model.GrpcGenericServiceGrpc;

//TODO complete implementation with channel
/***
 * Grpc session creation
 */
public class GrpcSession {

    private Channel channel;
    private GrpcGenericServiceGrpc.GrpcGenericServiceFutureStub futureStub;
    private static GrpcSession DEFAULT_SESSION = new GrpcSession(new Builder());
    private GrpcSession grpcSession;

    public GrpcSession getActiveSession(){
        return grpcSession;
    }

    private GrpcSession(Builder builder){
        this.grpcSession = builder.grpcSession;
    }

    public static final class Builder {
        private String hostNames = "";
        private int port = 0;
        private LoadBalanceType loadBalanceType;
        private GrpcSession grpcSession;

        public Builder setPort(int port){
            this.port = port;
            return this;
        }

        public Builder setHostNames(String hostNames) {
            this.hostNames = hostNames;
            return this;
        }

        public Builder setLoadBalanceType(LoadBalanceType loadBalanceType) {
            this.loadBalanceType = loadBalanceType;
            return this;
        }

        public GrpcSession getOrCreate(){
            if(null == this.grpcSession){
                return new GrpcSession(this);
            }
            return grpcSession;
        }
    }




}
