package com.example.una.user.service;

import com.example.una.user.model.User;
import com.example.una.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(String name, String email) {
        User user = new User(name, email);
        userRepository.save(user);
    }
}