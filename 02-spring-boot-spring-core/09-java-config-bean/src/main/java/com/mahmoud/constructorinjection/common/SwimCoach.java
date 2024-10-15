package com.mahmoud.constructorinjection.common;


public class SwimCoach implements Coach{
    public SwimCoach(){
        System.out.println("In Constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDialyWorkout() {
        return "Swim 1000 meters as a warm up";
    }
}
