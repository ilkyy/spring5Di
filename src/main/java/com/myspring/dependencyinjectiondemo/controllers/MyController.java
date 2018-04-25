package com.myspring.dependencyinjectiondemo.controllers;

import com.myspring.dependencyinjectiondemo.services.GreetingService;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {

    private GreetingService greetingService;

    public MyController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public void hello(){
        System.out.println("i am from myController");
    }
}
