package com.sda.spring.config;

import com.sda.spring.components.CustomFaker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public CustomFaker customFaker(){
        return new CustomFaker();
    }

}
