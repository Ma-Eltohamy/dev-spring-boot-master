package com.m0d.mvc_controller.mvc_controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {

    @GetMapping("/favicon.ico")
    public String getIcon(){
        return "forward:/images/v1.jpg";
    }


    @RequestMapping("/showForm")
    public String showForm(){
        return "form";
    }

    @RequestMapping("/processFormV1")
    public String processForm(@RequestParam(value = "studentName", required = true, defaultValue = "Unknown") String studentName, Model model){
        model.addAttribute("studentName", studentName);
        return "helloworld";
    }

    @RequestMapping("/processFormV2")
    public String processForm2(HttpServletRequest httpRequest, Model model){ // use @RequestBody with only sended json format
        String studentName = httpRequest.getParameter("studentName");
        studentName = studentName.toUpperCase();
        model.addAttribute("studentName", studentName);
        return "helloworld";
    }

    @RequestMapping("/processFormV3")
    public String processForm3(@RequestBody String studentName, Model model){ // use @RequestBody with only sended json format
        model.addAttribute("studentName", studentName);
        return "helloworld";
    }
}
