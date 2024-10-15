package com.mahmoud.constructorinjection.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BaseballCoach implements Coach{

    @Override
    public String getDialyWorkout() {
        return "Spend 30 mins in batting practice!";
    }
}
