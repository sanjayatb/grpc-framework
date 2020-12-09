package com.stb.grpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@ComponentScan(basePackages = "com.stb.grpc")
public class SpringGrpcApplication {



    public static void run(){
        SpringApplication.run(SpringGrpcApplication.class);
    }

    @EventListener
    public void onApplicationEvent(final ApplicationReadyEvent event){

    }

}
