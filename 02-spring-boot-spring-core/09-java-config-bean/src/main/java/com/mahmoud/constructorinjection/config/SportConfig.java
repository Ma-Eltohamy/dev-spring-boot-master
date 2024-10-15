package com.mahmoud.constructorinjection.config;

import com.mahmoud.constructorinjection.common.Coach;
import com.mahmoud.constructorinjection.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean("swimCoach")
    public Coach getSwimCoach(){
        return new SwimCoach();
    }
}
