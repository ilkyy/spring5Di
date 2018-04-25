package com.myspring.dependencyinjectiondemo.controllers;

import com.myspring.dependencyinjectiondemo.services.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class ContrructorController {

    public ContrructorController(@Qualifier("constructorService") GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    private GreetingService greetingService;

    public String say(){
        return greetingService.sayGreeting();
    }
}
