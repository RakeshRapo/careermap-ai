package com.careermap.careermap_ai.ai;

import org.springframework.stereotype.Component;

@Component
public class CareerAgent {

    public String generateRoadmap(
            String skills,
            String targetCompanies,
            String level,
            Integer studyHours) {

        return """
                Personalized Roadmap

                Skills: %s
                Target Companies: %s
                Current Level: %s
                Daily Study Hours: %d

                Month 1:
                - Strengthen DSA fundamentals
                - Practice Java Collections

                Month 2:
                - Spring Boot
                - REST APIs
                - JDBC

                Month 3:
                - System Design Basics
                - Mock Interviews
                - Company-specific preparation
                """.formatted(
                        skills,
                        targetCompanies,
                        level,
                        studyHours
                );
    }

    public String generateCareerRoadmap(
            String careerGoal,
            String skills,
            String level) {

        return """
                Career Goal: %s

                Skills: %s
                Level: %s

                Recommended Path:
                - Improve DSA
                - Build Projects
                - Learn Backend Development
                - Prepare for Interviews
                """.formatted(
                        careerGoal,
                        skills,
                        level
                );
    }
}   