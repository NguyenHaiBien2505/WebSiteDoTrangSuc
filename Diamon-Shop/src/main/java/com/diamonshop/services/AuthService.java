package com.diamonshop.services;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diamonshop.dtos.request.LoginRequest;
import com.diamonshop.entities.User;
import com.diamonshop.repositories.UserRepository;

@Service
public class AuthService {
    private final UserRepository userRepository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User authenticateUser(LoginRequest loginRequest){
        return userRepository.findUserByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
    }
}
