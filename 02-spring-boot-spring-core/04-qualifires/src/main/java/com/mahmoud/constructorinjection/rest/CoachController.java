package com.mahmoud.constructorinjection.rest;

import com.mahmoud.constructorinjection.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachController {

    private Coach coach;

    @Autowired
    CoachController(@Qualifier("trackCoach") Coach theCoach){
        coach = theCoach;
    }

    @GetMapping("/")
    public String getIndex(){
        System.out.println("The index endpoint has been hit");
        return "Hi, in my index page";
    }
    @GetMapping("/dailyWorkout")
    public String getDialyWorkout(){
        System.out.println("the daily work out end point has been hit :-)");
        return coach.getDialyWorkout();
    }
}
