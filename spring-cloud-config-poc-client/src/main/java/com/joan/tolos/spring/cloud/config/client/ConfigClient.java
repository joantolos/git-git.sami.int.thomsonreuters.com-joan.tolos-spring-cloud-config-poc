package com.joan.tolos.spring.cloud.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@ComponentScan
@RestController
@RefreshScope
public class ConfigClient {
    @Value("${my.property}")
    String myProperty;

    @RequestMapping("/")
    String ping() {
        return "Client config Alive!";
    }

    @RequestMapping("/myproperty")
    String myProperty() {
        return "My Property: "+ myProperty;
    }

    public static void main(String[] args) {
        SpringApplication.run(ConfigClient.class, args);
    }
}