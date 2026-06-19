package com.careermap.careermap_ai.controller;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.careermap.careermap_ai.dto.RegisterRequest;
import com.careermap.careermap_ai.entity.User;
import com.careermap.careermap_ai.service.UserService;
import com.careermap.careermap_ai.dto.ProfileRequest;
import com.careermap.careermap_ai.entity.UserProfile;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest request) {
        return userService.register(request);
    }
    @PostMapping("/profile")
public UserProfile saveProfile(
        @RequestBody ProfileRequest request) {

    return userService.saveProfile(request);
}
    @GetMapping("/users")
public List<User> getUsers() {
    return userService.getAllUsers();
}
@GetMapping("/users/{id}")
public User getUserById(@PathVariable Long id) {
    return userService.getUserById(id);
}
@GetMapping("/roadmap/{userId}")
public String generateRoadmap(
        @PathVariable Long userId) {

    return userService.generateRoadmap(userId);
}

    
}