package com.careermap.careermap_ai.dto;

import lombok.Data;

@Data
public class ProfileRequest {

    private String skills;
    private String targetCompanies;
    private Integer dailyStudyHours;
    private String currentLevel;
    private Long userId;
}