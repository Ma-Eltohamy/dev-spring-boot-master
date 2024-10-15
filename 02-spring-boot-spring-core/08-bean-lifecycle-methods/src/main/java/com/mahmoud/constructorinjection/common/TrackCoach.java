package com.mahmoud.constructorinjection.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class TrackCoach implements Coach{
    TrackCoach(){
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @PostConstruct
    public void doConstructingStaff(){
        System.out.println("In my @PostConstruct: " + getClass().getSimpleName());
    }

    @PreDestroy
    @Override
    public void clean(){
        System.out.println("In my @PreDestroy: " + getClass().getSimpleName());
    }

    @Override
    public String getDialyWorkout() {
        return "Run for 2 hours";
    }
}
