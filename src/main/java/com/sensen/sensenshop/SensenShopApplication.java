package com.sensen.sensenshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SensenShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(SensenShopApplication.class, args);
    }

}
