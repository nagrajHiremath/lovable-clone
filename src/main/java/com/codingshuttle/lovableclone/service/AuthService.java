package com.codingshuttle.lovableclone.service;

import com.codingshuttle.lovableclone.dto.auth.AuthResponse;
import com.codingshuttle.lovableclone.dto.auth.LoginRequest;
import com.codingshuttle.lovableclone.dto.auth.SignUpRequest;


public interface AuthService {
    AuthResponse login(LoginRequest loginRequest);

    AuthResponse signUp(SignUpRequest signUpRequest);

    SignUpRequest getProfile();
}
