package com.tedu.sp09;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringCloudApplication
public class Sp09FeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sp09FeignApplication.class, args);
    }
}