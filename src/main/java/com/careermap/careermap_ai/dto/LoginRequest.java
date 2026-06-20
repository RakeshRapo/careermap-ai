package com.careermap.careermap_ai.dto;

import lombok.Data;

@Data
public class LoginRequest {

    private String email;
    private String password;
}