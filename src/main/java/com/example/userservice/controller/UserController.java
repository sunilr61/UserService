package com.example.userservice.controller;

import com.example.userservice.models.User;
import com.example.userservice.dtos.SignUpRequestDto;
import com.example.userservice.dtos.UserDto;
import com.example.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }
    // To build login, signup, logout,token validate
    @PostMapping("/signup")
    public UserDto signup(@RequestBody SignUpRequestDto requestDto){
        User user = userService.signup(
                requestDto.getName(),
                requestDto.getEmail(),
                requestDto.getPassword());

        return UserDto.from(user);
    }

}
