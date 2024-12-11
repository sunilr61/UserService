package com.example.userservice.services;

import com.example.userservice.models.User;

public interface UserService {
    User signup(String name, String email, String password);
}
