package com.semo.kvokka.controller;

import com.semo.kvokka.entity.UserProfile;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class ProfileController {

    @GetMapping("/profile")
    public UserProfile profile() {
        return (UserProfile) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
