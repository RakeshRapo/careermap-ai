package com.careermap.careermap_ai.controller;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.careermap.careermap_ai.ai.ResumeAgent;
import com.careermap.careermap_ai.dto.ProfileRequest;
import com.careermap.careermap_ai.dto.RegisterRequest;
import com.careermap.careermap_ai.entity.User;
import com.careermap.careermap_ai.entity.UserProfile;
import com.careermap.careermap_ai.service.GeminiService;
import com.careermap.careermap_ai.service.UserService;

import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final ResumeAgent resumeAgent;
    private final UserService userService;
    private final GeminiService geminiService;
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
@GetMapping("/gemini")
public String geminiTest() {

    return geminiService.generateRoadmap(
            "Create a 3 month roadmap for a Java Spring Boot developer");
}
@GetMapping("/resume/analyze")
public String analyzeResume() {

    return resumeAgent.analyzeResume(
            "Java Spring Boot SQL AWS");
}
@GetMapping("/resume/analyze/{userId}")
public String analyzeResume(@PathVariable Long userId) {
    return userService.analyzeResume(userId);
}
@GetMapping("/dsa-plan/{userId}")
public String generateDsaPlan(
        @PathVariable Long userId) {

    return userService.generateDsaPlan(userId);
}
@GetMapping("/interview/{userId}")
public String generateInterviewQuestions(
        @PathVariable Long userId) {

    return userService.generateInterviewQuestions(userId);
}
@GetMapping("/career-roadmap/{userId}")
public String generateCareerRoadmap(
        @PathVariable Long userId) {

    return userService.generateCareerRoadmap(userId);
}
}