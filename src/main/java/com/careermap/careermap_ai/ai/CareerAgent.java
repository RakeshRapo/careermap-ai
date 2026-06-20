package com.careermap.careermap_ai.ai;

import org.springframework.stereotype.Component;

@Component
public class CareerAgent {

    public String generateCareerRoadmap(
            String careerGoal,
            String skills,
            String level) {

        return """
                Personalized Career Roadmap

                Career Goal:
                %s

                Current Skills:
                %s

                Current Level:
                %s

                Phase 1:
                - Strengthen Java
                - Learn OOP
                - Master Collections

                Phase 2:
                - DSA Practice
                - LeetCode
                - SQL

                Phase 3:
                - Spring Boot
                - REST APIs
                - PostgreSQL

                Phase 4:
                - Build Projects
                - Resume Preparation
                - Interview Preparation

                Phase 5:
                - Apply for Internships
                - Apply for SDE Roles
                """
                .formatted(careerGoal, skills, level);
    }
}