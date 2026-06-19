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
                Career Roadmap

                Current Skills: %s
                Target Companies: %s
                Current Level: %s
                Daily Study Hours: %d

                Suggested Plan:

                Month 1:
                - Java Fundamentals
                - OOP

                Month 2:
                - DSA Arrays
                - Strings

                Month 3:
                - Spring Boot
                - PostgreSQL

                Month 4:
                - Projects
                - Resume Building

                Month 5:
                - Mock Interviews

                Month 6:
                - Company Preparation
                """
                .formatted(
                        skills,
                        targetCompanies,
                        level,
                        studyHours);
    }
}