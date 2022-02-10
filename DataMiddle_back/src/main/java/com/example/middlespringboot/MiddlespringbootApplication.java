package com.example.middlespringboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class MiddlespringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiddlespringbootApplication.class, args);
    }

    @Bean
    public RestTemplate initRestTemplate() {
        return new RestTemplate();
    }


}
