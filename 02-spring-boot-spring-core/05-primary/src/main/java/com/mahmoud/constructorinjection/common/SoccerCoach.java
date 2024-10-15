package com.mahmoud.constructorinjection.common;

import org.springframework.stereotype.Component;

@Component
public class SoccerCoach implements Coach{

    @Override
    public String getDialyWorkout() {
        return "Hi, I am Ramy your Soccer Coach, you will have to practice for 20 mins";
    }
}
