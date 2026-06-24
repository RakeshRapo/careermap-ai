package com.careermap.careermap_ai.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.careermap.careermap_ai.service.ResumeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class ResumeController {

    private final ResumeService resumeService;

    @PostMapping("/resume/upload")
    public ResponseEntity<String> uploadResume(
            @RequestParam("file") MultipartFile file) {

        try {

            String text =
                    resumeService.extractText(file);

            return ResponseEntity.ok(text);

        } catch (Exception e) {

            return ResponseEntity.badRequest()
                    .body("Error reading PDF: "
                            + e.getMessage());
        }
    }
}