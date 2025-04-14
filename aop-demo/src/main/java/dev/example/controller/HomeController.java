package dev.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aop")
public class HomeController {

    @GetMapping("/home")
    public String home() {
        //Logging
        //Authentication and authorization
        System.out.println("HomeController is called.");
        return "Hello AOP!";
    }
}
