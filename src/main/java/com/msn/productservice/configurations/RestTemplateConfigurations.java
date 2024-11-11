package com.msn.productservice.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfigurations {
    @Bean
    public RestTemplate restTemplate() {
        // TODO Auto-generated method stub
        return new RestTemplate();
    }
}
