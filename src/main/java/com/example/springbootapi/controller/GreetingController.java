package com.example.springbootapi.controller;

import com.example.springbootapi.service.GreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/api/greet")
    public String greet(@RequestParam(defaultValue = "Hello") String name) {
        return greetingService.getGreeting(name);
    }

    @GetMapping("/api/goodbye")
    public String goodbye(@RequestParam(defaultValue = "Goodbye") String name) {
        return greetingService.getGoodbye(name);
    }
}
