package com.careermap.careermap_ai.service;

import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.careermap.careermap_ai.config.GeminiConfig;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GeminiService {

    private final GeminiConfig geminiConfig;
    private final RestTemplate restTemplate;

    public String generateRoadmap(String prompt) {

        String url =
                "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key="
                        + geminiConfig.getApiKey();
    
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
    
        Map<String, Object> body = Map.of(
                "contents",
                new Object[]{
                        Map.of(
                                "parts",
                                new Object[]{
                                        Map.of("text", prompt)
                                })
                });
    
        HttpEntity<Map<String, Object>> request =
                new HttpEntity<>(body, headers);
    
        try {
    
            ResponseEntity<String> response =
                    restTemplate.postForEntity(
                            url,
                            request,
                            String.class);
    
            return response.getBody();
    
        } catch (Exception e) {
    
            return "Gemini Error: " + e.getMessage();
    
        }
    }
}