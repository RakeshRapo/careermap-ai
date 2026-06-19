package com.careermap.careermap_ai.service;
import java.util.List;

import org.springframework.stereotype.Service;
import com.careermap.careermap_ai.dto.ProfileRequest;
import com.careermap.careermap_ai.entity.UserProfile;
import com.careermap.careermap_ai.repository.UserProfileRepository;
import com.careermap.careermap_ai.dto.RegisterRequest;
import com.careermap.careermap_ai.entity.User;
import com.careermap.careermap_ai.repository.UserRepository;
import com.careermap.careermap_ai.ai.CareerAgent;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CareerAgent careerAgent;
    private final UserProfileRepository userProfileRepository;
    public User register(RegisterRequest request) {

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .year(request.getYear())
                .careerGoal(request.getCareerGoal())
                .build();

        return userRepository.save(user);
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));
    }
    public UserProfile saveProfile(ProfileRequest request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
    
        UserProfile profile = UserProfile.builder()
                .skills(request.getSkills())
                .targetCompanies(request.getTargetCompanies())
                .dailyStudyHours(request.getDailyStudyHours())
                .currentLevel(request.getCurrentLevel())
                .user(user)
                .build();
    
        return userProfileRepository.save(profile);
    }
    public String generateRoadmap(Long userId) {

        UserProfile profile = userProfileRepository.findAll()
                .stream()
                .filter(p -> p.getUser().getId().equals(userId))
                .findFirst()
                .orElseThrow(() ->
                        new RuntimeException("Profile not found"));
    
        return careerAgent.generateRoadmap(
                profile.getSkills(),
                profile.getTargetCompanies(),
                profile.getCurrentLevel(),
                profile.getDailyStudyHours()
        );
    }
}