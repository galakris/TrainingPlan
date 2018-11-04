package com.example.trainingplan.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;


@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Principal principal){
        System.out.println(principal.getName());
        return "index";
    }

    @GetMapping("/test")
    public String test(){
        return "test";
    }
}
