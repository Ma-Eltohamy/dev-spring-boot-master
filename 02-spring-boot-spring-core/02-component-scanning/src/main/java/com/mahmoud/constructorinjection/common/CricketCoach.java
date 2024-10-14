package com.mahmoud.constructorinjection.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CricketCoach implements Coach {

    @Override
    public String getDialyWorkout() {
        return "I am your \"Cricket Coach\" practice for 10 mins !!";
    }
}
