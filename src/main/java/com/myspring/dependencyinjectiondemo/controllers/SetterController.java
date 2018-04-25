package com.myspring.dependencyinjectiondemo.controllers;

import com.myspring.dependencyinjectiondemo.services.GreetingService;
import com.myspring.dependencyinjectiondemo.services.GreetingServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class SetterController {

    @Autowired
    public void setGreetingService(@Qualifier("setterService") GreetingService greetingService) {
        this.greetingService = greetingService;
    }


    private GreetingService greetingService;


    public String say(){
        return greetingService.sayGreeting();
    }

}
