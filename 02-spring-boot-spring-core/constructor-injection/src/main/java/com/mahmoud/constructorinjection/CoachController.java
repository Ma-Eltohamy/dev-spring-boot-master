package com.mahmoud.constructorinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachController {

    private Coach coach;

    @Autowired
    public CoachController(Coach theCoach){
        coach = theCoach;
    }

    @GetMapping("/dailyWorkout")
    public String getDialyWorkout(){
        return coach.getDialyWorkout();
    }
}
