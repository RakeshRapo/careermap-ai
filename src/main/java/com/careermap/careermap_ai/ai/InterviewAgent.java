package com.careermap.careermap_ai.ai;

import org.springframework.stereotype.Component;

@Component
public class InterviewAgent {

    public String generateQuestions(String careerGoal) {

        if (careerGoal.toLowerCase().contains("java")) {

            return """
                    Java Backend Interview Questions

                    1. What is OOP?
                    2. Difference between List and Set?
                    3. What is Spring Boot?
                    4. What is Dependency Injection?
                    5. What is JPA?
                    6. Difference between HashMap and Hashtable?
                    7. Explain REST APIs.
                    8. What is JWT?
                    9. Explain Microservices.
                    10. What is Hibernate?
                    """;
        }

        return """
                General Interview Questions

                1. Tell me about yourself.
                2. Why should we hire you?
                3. What are your strengths?
                4. What are your weaknesses?
                5. Describe a challenging project.
                """;
    }
}