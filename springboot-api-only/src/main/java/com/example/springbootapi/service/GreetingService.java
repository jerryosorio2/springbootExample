package com.example.springbootapi.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public String getGreeting(String name) {
        return "Cherry Hello, " + name;
    }

    public String getGoodbye(String name) {
        return "Bli Goodbye, " + name;
    }
}
