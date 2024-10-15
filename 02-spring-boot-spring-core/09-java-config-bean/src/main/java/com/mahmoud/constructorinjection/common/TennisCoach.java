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

}
