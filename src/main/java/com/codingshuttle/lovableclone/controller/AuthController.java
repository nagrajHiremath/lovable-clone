package com.codingshuttle.lovableclone.controller;

import com.codingshuttle.lovableclone.dto.auth.AuthResponse;
import com.codingshuttle.lovableclone.dto.auth.LoginRequest;
import com.codingshuttle.lovableclone.dto.auth.SignUpRequest;
import com.codingshuttle.lovableclone.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("signUp")
    public ResponseEntity<AuthResponse> signUp(SignUpRequest signUpRequest){
        return ResponseEntity.ok(authService.signUp(signUpRequest));
    }
    @PostMapping("login")
    public ResponseEntity<AuthResponse> login(LoginRequest loginRequest){
        return ResponseEntity.ok(authService.login(loginRequest));
    }
    @GetMapping
    public ResponseEntity<SignUpRequest> getProfile(){
        return ResponseEntity.ok(authService.getProfile());
    }
}
