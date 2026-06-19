package com.codingshuttle.lovableclone.service.impl;

import com.codingshuttle.lovableclone.dto.auth.AuthResponse;
import com.codingshuttle.lovableclone.dto.auth.LoginRequest;
import com.codingshuttle.lovableclone.dto.auth.SignUpRequest;
import com.codingshuttle.lovableclone.entity.User;
import com.codingshuttle.lovableclone.mapper.auth.AuthMapper;
import com.codingshuttle.lovableclone.repository.UserRepository;
import com.codingshuttle.lovableclone.security.AuthUtil;
import com.codingshuttle.lovableclone.service.AuthService;
import jakarta.servlet.http.Cookie;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    UserRepository userRepository;
    AuthMapper authMapper;
    AuthUtil authUtil;
    PasswordEncoder passwordEncoder;
    AuthenticationManager authenticationManager;

    public AuthResponse signUp(SignUpRequest signUpRequest) {

        Optional<User> user = userRepository.findByUsername(signUpRequest.username());

        if(user.isPresent()){
            throw new RuntimeException("User already exist");
        }

        User newUser = authMapper.toUserEntity(signUpRequest);
        newUser.setPassword(passwordEncoder.encode(signUpRequest.password()));
        userRepository.save(newUser);

        String accessToken = authUtil.generateAccessToken(newUser);
        Cookie cookie = new Cookie("refreshToken", authUtil.generateRefreshToken(newUser));

        return new AuthResponse(accessToken, authMapper.toUserProfileResponse(newUser));
    }

    public AuthResponse login(LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password()));

        User user = (User) authentication.getPrincipal();
        return new AuthResponse(authUtil.generateAccessToken(user), authMapper.toUserProfileResponse(user));
    }

    public SignUpRequest getProfile() {
        return null;
    }
}
