package com.myspring.dependencyinjectiondemo.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class PrimaryService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "i am from primary service";
    }
}
