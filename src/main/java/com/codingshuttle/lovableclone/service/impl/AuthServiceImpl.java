package com.codingshuttle.lovableclone.service.impl;

import com.codingshuttle.lovableclone.dto.auth.AuthResponse;
import com.codingshuttle.lovableclone.dto.auth.LoginRequest;
import com.codingshuttle.lovableclone.dto.auth.SignUpRequest;
import com.codingshuttle.lovableclone.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    public AuthResponse login(LoginRequest loginRequest) {
        return null;
    }

    public AuthResponse signUp(SignUpRequest signUpRequest) {
        return null;
    }

    public SignUpRequest getProfile() {
        return null;
    }
}
