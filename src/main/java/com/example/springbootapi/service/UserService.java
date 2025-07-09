package com.example.springbootapi.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public String searchUser(String userId) {
        return "User search succesfully: " + userId;
    }

    public String deleteUser(String userId) {
        return "User deleted: " + userId;
    }
}
