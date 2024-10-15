package com.mahmoud.constructorinjection.common;

import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    TennisCoach(){
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDialyWorkout() {
        return "Practice your backhand volley";
    }

    @PreDestroy
    @Override
    public void clean(){
        System.out.println("In my @PreDestroy: " + getClass().getSimpleName());
    }
}
