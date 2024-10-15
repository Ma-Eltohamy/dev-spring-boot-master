package com.mahmoud.constructorinjection.common;

import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class SoccerCoach implements Coach{
    SoccerCoach(){
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDialyWorkout() {
        return "Hi, I am Ramy your Soccer Coach, you will have to practice for 20 mins";
    }

    @PreDestroy
    @Override
    public void clean(){
        System.out.println("In my @PreDestroy: " + getClass().getSimpleName());
    }
}
