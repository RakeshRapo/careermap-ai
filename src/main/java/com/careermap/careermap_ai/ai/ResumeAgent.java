package com.careermap.careermap_ai.ai;

import org.springframework.stereotype.Component;

@Component
public class ResumeAgent {

    public String analyzeResume(String skills) {

        int score = 50;

        if (skills.toLowerCase().contains("java")) {
            score += 15;
        }

        if (skills.toLowerCase().contains("spring")) {
            score += 15;
        }

        if (skills.toLowerCase().contains("sql")) {
            score += 10;
        }

        if (skills.toLowerCase().contains("aws")) {
            score += 10;
        }

        return """
                Resume Analysis

                Resume Score: %d/100

                Suggestions:
                - Add more projects
                - Include achievements
                - Add internship experience
                - Improve ATS keywords
                """.formatted(score);
    }
}