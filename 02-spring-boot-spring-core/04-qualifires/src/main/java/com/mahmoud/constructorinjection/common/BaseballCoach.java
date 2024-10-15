package com.mahmoud.constructorinjection.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{

    @Override
    public String getDialyWorkout() {
        return "Spend 30 mins in batting practice!";
    }
}
