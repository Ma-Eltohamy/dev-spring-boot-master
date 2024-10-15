package com.mahmoud.constructorinjection.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach{
    @Override
    public String getDialyWorkout() {
        return "Run for 2 hours";
    }
}
