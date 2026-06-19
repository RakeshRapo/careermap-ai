package com.careermap.careermap_ai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.careermap.careermap_ai.entity.User;

public interface UserRepository
        extends JpaRepository<User, Long> {
}