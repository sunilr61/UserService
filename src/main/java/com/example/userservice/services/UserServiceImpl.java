package com.example.userservice.services;

import com.example.userservice.models.User;
import com.example.userservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @Override
    public User signup(String name, String email, String password)  {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if(userOptional.isPresent()){
            return userOptional.get();
        }
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        return userRepository.save(user);

    }
}
