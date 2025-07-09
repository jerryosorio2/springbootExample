package com.example.springbootapi.controller;

import com.example.springbootapi.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/users/search")
    public String userSearch(@RequestParam() String userId) {
        return userService.searchUser(userId);
    }

    @GetMapping("/api/users/delete")
    public String goodbye(@RequestParam() String userId) {
        return userService.deleteUser(userId);
    }
}
