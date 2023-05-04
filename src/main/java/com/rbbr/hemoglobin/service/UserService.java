package com.rbbr.hemoglobin.service;

import com.rbbr.hemoglobin.dto.TokenDTO;
import com.rbbr.hemoglobin.dto.UserLoginDTO;
import com.rbbr.hemoglobin.entity.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {
    TokenDTO authenticateUser(UserLoginDTO inputUser);
    void logout(String token);
}
