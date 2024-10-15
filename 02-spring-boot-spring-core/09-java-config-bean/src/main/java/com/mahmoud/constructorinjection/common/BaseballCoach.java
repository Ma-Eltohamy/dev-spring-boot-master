package com.mahmoud.constructorinjection.common;

import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{
    BaseballCoach(){
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDialyWorkout() {
        return "Spend 30 mins in batting practice!";
    }

}
