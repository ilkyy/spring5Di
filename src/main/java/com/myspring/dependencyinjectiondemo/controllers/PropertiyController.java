package com.myspring.dependencyinjectiondemo.controllers;

import com.myspring.dependencyinjectiondemo.services.GreetingService;
import com.myspring.dependencyinjectiondemo.services.GreetingServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class PropertiyController {

    @Autowired
    public GreetingService greetingServiceImp;

    public String say(){
        return greetingServiceImp.sayGreeting();
    }
}
