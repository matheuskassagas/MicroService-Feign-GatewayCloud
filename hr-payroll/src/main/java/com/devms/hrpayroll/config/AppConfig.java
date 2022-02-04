package com.devms.hrpayroll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean //registra uma unica instancia de um objeto
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
