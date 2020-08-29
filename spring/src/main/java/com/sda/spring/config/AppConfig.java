package com.sda.spring.config;

import com.sda.spring.components.CustomFaker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("com.sda.spring.components")
public class AppConfig {


    /**
     * Am comentat bean-ul deoarece am folosit @ComponentScan si @Component pe clasa CustomFaker
     */
//    @Bean
//    public CustomFaker customFaker(){
//        return new CustomFaker();
//    }

}
