package com.myspring.dependencyinjectiondemo.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImp implements GreetingService {
    public static String message = "i am from greetingServiceImp";
    @Override
    public String sayGreeting() {
        return message;
    }
}
