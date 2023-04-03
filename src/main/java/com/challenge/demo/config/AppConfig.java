package com.challenge.demo.config;

import com.challenge.demo.repository.DemoExternalRepo;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public DemoExternalRepo repository(RestTemplate restTemplate) {
        return new DemoExternalRepo(restTemplate);
    }
}
