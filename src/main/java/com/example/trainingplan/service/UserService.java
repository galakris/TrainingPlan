package com.example.trainingplan.service;

import com.example.trainingplan.model.User;
import com.example.trainingplan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;/*
    private BCryptPasswordEncoder bCryptPasswordEncoder;*/

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void add(User user){/*
        System.out.println("Przed: " + user.getPassword() );
        String passwordHash = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(passwordHash);
        System.out.println("Po: " + user.getPassword() );*/
        userRepository.save(user);
    }

}
