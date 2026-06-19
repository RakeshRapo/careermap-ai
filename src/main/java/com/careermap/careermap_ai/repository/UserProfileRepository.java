package com.careermap.careermap_ai.repository;

import com.careermap.careermap_ai.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository
        extends JpaRepository<UserProfile, Long> {
}