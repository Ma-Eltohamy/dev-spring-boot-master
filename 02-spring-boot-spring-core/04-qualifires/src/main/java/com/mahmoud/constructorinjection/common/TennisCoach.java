package com.mahmoud.constructorinjection.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{

    @Override
    public String getDialyWorkout() {
        return "Practice your backhand volley";
    }
}
