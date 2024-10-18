package com.m0d.springbootrestcrud.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoRestController {

    @GetMapping("/hello")
    @ResponseBody
    public String sayHello(){
        return "Hello, World";
    }
}
