package com.careermap.careermap_ai.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_profiles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String skills;

    private String targetCompanies;

    private Integer dailyStudyHours;

    private String currentLevel;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}