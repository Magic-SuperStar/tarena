package com.tedu.sp07;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

//@EnableCircuitBreaker
//@EnableDiscoveryClient
//@SpringBootApplication
@SpringCloudApplication
public class Sp07HystrixApplication {

    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate(){
        SimpleClientHttpRequestFactory schrf = new SimpleClientHttpRequestFactory();
        schrf.setReadTimeout(1000);
        schrf.setConnectTimeout(1000);
        return new RestTemplate(schrf);
        //两个属性默认值是-1，是不会开启
//        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(Sp07HystrixApplication.class, args);
    }

}
