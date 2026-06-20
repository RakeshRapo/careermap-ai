package com.careermap.careermap_ai.ai;

import org.springframework.stereotype.Component;

import com.careermap.careermap_ai.service.GeminiService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CareerAgent {

    private final GeminiService geminiService;

    public String generateRoadmap(
        String skills,
        String targetCompanies,
        String level,
        Integer studyHours) {

    String prompt = """
            Create a personalized career roadmap.

            Skills: %s
            Target Companies: %s
            Current Level: %s
            Daily Study Hours: %d

            Create a detailed 3-month roadmap.
            Include:
            - Weekly goals
            - Technologies to learn
            - DSA preparation
            - Projects to build
            - Interview preparation
            """.formatted(
                    skills,
                    targetCompanies,
                    level,
                    studyHours
            );

    return geminiService.generateRoadmap(prompt);
}

public String generateCareerRoadmap(
        String careerGoal,
        String skills,
        String level,   
        String year) {

                String prompt = """
                        Create a personalized career roadmap.
                        
                        Current Academic Year: %s
                        Career Goal: %s
                        Skills: %s
                        Current Level: %s
                        
                        Generate a roadmap that lasts until graduation.
                        
                        If the student is:
                        - 1st Year → roadmap for 4 years
                        - 2nd Year → roadmap for 3 years
                        - 3rd Year → roadmap for 2 years
                        - Final Year → roadmap for remaining months
                        
                        Keep it concise.
                        
                        Return:
                        🎯 Goal
                        📚 Skills
                        🛠 Projects
                        📅 Timeline Until Graduation
                        """.formatted(
                                year,
                                careerGoal,
                                skills,
                                level
                        );

    return geminiService.generateRoadmap(prompt);
}
}   