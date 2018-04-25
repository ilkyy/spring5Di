package com.myspring.dependencyinjectiondemo.services;

import org.springframework.stereotype.Service;

@Service
public class ConstructorService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "i am from constrouctorService";
    }
}
