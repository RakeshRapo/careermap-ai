package com.careermap.careermap_ai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.careermap.careermap_ai.entity.UserProfile;

public interface UserProfileRepository
        extends JpaRepository<UserProfile, Long> {

    Optional<UserProfile> findByUserId(Long userId);
}