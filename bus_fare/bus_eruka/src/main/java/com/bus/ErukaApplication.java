package com.bus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ErukaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ErukaApplication.class, args);
        System.out.println("=================================================================================================");
        System.out.println("========================================eureka service run success, port is 8761==================");
    }

}
