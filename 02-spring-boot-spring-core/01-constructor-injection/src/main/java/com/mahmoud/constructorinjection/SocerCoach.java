package com.mahmoud.constructorinjection;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class SocerCoach implements Coach{

    @Override
    public String getDialyWorkout() {
        return "Hi, I am Ramy your Soccer Coach, you will have to practice for 20 mins";
    }
}
