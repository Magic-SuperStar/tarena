package com.tedu.sp06;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class Sp06RibbonApplication {
    //创建 RestTemplate 实例，并存入spring容器
    @Bean
    public RestTemplate getRestTemplate() {
        //RestTemplate 是用来调用其他微服务的工具类，封装远程调用代码，提供了一组用于远程调用的模板方法
        //e.g. getForObject()/postForObject()等
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(Sp06RibbonApplication.class, args);
    }

}
