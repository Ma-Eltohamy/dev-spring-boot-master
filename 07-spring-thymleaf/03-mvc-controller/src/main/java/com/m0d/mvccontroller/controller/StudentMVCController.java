package com.m0d.mvccontroller.controller;

import com.m0d.mvccontroller.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentMVCController {

    @Value("${countries}")
    List<String> countriesList;

    @Value("${languages}")
    List<String> languagesList;

    @Value("${operatingSystems}")
    List<String> operatingSystemsList;

    @GetMapping("/signIn")
    public String singin(Model model){
        model.addAttribute("student", new Student());
        model.addAttribute("countriesList", countriesList);
        model.addAttribute("languagesList", languagesList);
        model.addAttribute("operationSystemsList", operatingSystemsList);
        return "sign_in";
    }

    @PostMapping("/welcome")
    public String welcome(@ModelAttribute("student") Student student, Model model){
        return "welcome";
    }
}
