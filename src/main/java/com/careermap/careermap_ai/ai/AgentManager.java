package com.careermap.careermap_ai.ai;

import org.springframework.stereotype.Component;

@Component
public class AgentManager {

    private final CareerAgent careerAgent;

    public AgentManager(CareerAgent careerAgent) {
        this.careerAgent = careerAgent;
    }

    public String generateCareerRoadmap(
            String skills,
            String targetCompanies,
            String level,
            Integer studyHours) {

        return careerAgent.generateRoadmap(
                skills,
                targetCompanies,
                level,
                studyHours
        );
    }
}