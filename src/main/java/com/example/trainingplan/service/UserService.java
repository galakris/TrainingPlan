package com.example.trainingplan.service;

import com.example.trainingplan.model.User;
import com.example.trainingplan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void add(User user){
        userRepository.save(user);
    }

    public User findUserByLogin(String name) {
        return userRepository.findByLogin(name);
    }
}
