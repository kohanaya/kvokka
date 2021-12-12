package com.semo.kvokka.controller;

import com.semo.kvokka.entity.UserProfile;
import com.semo.kvokka.exception.BadRequestException;
import com.semo.kvokka.model.RegisterRequest;
import com.semo.kvokka.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class AuthController {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @PostMapping("/register")
    public void register(@RequestBody RegisterRequest req) {
        if (userRepository.findByUsername(req.getUsername()).isPresent()) {
            throw new BadRequestException("Such user already exists.");
        }
        userRepository.save(UserProfile.builder()
                .fullName(req.getFullName())
                .username(req.getUsername())
                .password(passwordEncoder.encode(req.getPassword()))
                .createdAt(Instant.now())
                .build());
    }


}
