package com.mahmoud.constructorinjection.rest;

import com.mahmoud.constructorinjection.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachController {

    private final Coach myCoach;

    @Autowired
    CoachController(@Qualifier("trackCoach") Coach theCoach){
        System.out.println("In constructor: " + getClass().getSimpleName());

        myCoach = theCoach;
        myCoach.clean();
    }

    @GetMapping("/")
    public String getIndex(){
        System.out.println("The index endpoint has been hit");
        return "Hi, in my index page";
    }
    @GetMapping("/dailyWorkout")
    public String getDialyWorkout(){
        System.out.println("the daily work out end point has been hit :-)");
        return myCoach.getDialyWorkout();
    }

}

