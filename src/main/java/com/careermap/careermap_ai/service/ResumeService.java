package com.careermap.careermap_ai.service;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ResumeService {

    public String extractText(MultipartFile file)
            throws IOException {

        PDDocument document =
                PDDocument.load(file.getInputStream());

        PDFTextStripper pdfStripper =
                new PDFTextStripper();

        String text =
                pdfStripper.getText(document);

        document.close();

        return text;
    }
}