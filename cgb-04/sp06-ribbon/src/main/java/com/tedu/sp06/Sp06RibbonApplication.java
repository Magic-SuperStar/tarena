package com.tedu.sp06;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@EnableDiscoveryClient
@SpringBootApplication
public class Sp06RibbonApplication {
    @LoadBalanced //负载均衡，会对RestTemplate实例进行封装，创建动态代理对象，并切入（AOP）负载均衡代码，把请求分散分发到集群中的服务器
    @Bean//创建 RestTemplate 实例，并存入spring容器
    public RestTemplate getRestTemplate() {
        //RestTemplate 是用来调用其他微服务的工具类，封装远程调用代码，提供了一组用于远程调用的模板方法
        //e.g. getForObject()/postForObject()等

        SimpleClientHttpRequestFactory schrf=new SimpleClientHttpRequestFactory();
        schrf.setConnectTimeout(1000);
        schrf.setReadTimeout(1000);
        return new RestTemplate(schrf);
        //RestTemplate 中默认的Factory 实例中，两个超时属性默认是-1
        //未启用超时，也不会触发重试
        //return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(Sp06RibbonApplication.class, args);
    }

}
