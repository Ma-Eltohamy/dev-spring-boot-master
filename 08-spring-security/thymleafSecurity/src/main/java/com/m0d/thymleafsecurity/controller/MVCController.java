package com.m0d.thymleafsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MVCController {

    @GetMapping("/")
    public String showHome(){
        return "home";
    }

    @GetMapping("/showLogInPage")
    public String logIn(){
        return "logIn";
    }

    @GetMapping("/leaders")
    public String showLeaders(){
        return "leaders";
    }

    @GetMapping("/systems")
    public String showSystems(){
        return "systems";
    }

    @GetMapping("accessDenied")
    public String showAccessDenied(){
        return "accessDenied";
    }
}
