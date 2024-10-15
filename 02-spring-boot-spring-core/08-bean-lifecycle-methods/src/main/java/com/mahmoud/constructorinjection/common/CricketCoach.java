package com.mahmoud.constructorinjection.common;

import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    @Override
    public String getDialyWorkout() {
        return "I am your \"Cricket Coach\" practice for 10 mins !!";
    }

    @PreDestroy
    @Override
    public void clean(){
        System.out.println("In my @PreDestroy: " + getClass().getSimpleName());
    }
}
