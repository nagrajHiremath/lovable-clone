package com.codingshuttle.lovableclone.controller;

import com.codingshuttle.lovableclone.dto.auth.AuthResponse;
import com.codingshuttle.lovableclone.dto.auth.LoginRequest;
import com.codingshuttle.lovableclone.dto.auth.SignUpRequest;
import com.codingshuttle.lovableclone.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signUp")
    public ResponseEntity<AuthResponse> signUp(@RequestBody SignUpRequest signUpRequest){
        return ResponseEntity.ok(authService.signUp(signUpRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(authService.login(loginRequest));
    }

    @GetMapping
    public ResponseEntity<SignUpRequest> getProfile(){
        return ResponseEntity.ok(authService.getProfile());
    }
}
