package com.mahmoud.springboot.demo.RestControllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    @Value("${project.creator}")
    String projectCreatorName;

    @Value("${supervisor.name}")
    String supervisorName;

    @GetMapping("/")
    public String sayHello(){
        String result1 = "The project creator name is: " + projectCreatorName;
        String result2 = "The supervisor name is: " + supervisorName;

        return result1 + "</br>"+ result2;
    }



}
