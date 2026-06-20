package com.careermap.careermap_ai.service;

import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.careermap.careermap_ai.config.GeminiConfig;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GeminiService {

    private final GeminiConfig geminiConfig;
    private final RestTemplate restTemplate;

    public String generateRoadmap(String prompt) {

        String url =
                "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent?key="
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
    
                            ObjectMapper mapper = new ObjectMapper();

                            JsonNode root =
                                    mapper.readTree(response.getBody());
                            
                            return root
                                    .path("candidates")
                                    .get(0)
                                    .path("content")
                                    .path("parts")
                                    .get(0)
                                    .path("text")
                                    .asText();
    
        } catch (Exception e) {
    
            return "Gemini Error: " + e.getMessage();
    
        }
    }
}