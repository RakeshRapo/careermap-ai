package com.careermap.careermap_ai.ai;

import org.springframework.stereotype.Component;

@Component
public class DsaAgent {

    public String generatePlan(String level) {

        if (level.equalsIgnoreCase("Beginner")) {

            return """
                    Beginner DSA Plan (30 Days)

                    Week 1:
                    - Arrays
                    - Strings

                    Week 2:
                    - Linked List
                    - Stack
                    - Queue

                    Week 3:
                    - Recursion
                    - Binary Search

                    Week 4:
                    - Trees
                    - Basic Graphs
                    """;
        }

        if (level.equalsIgnoreCase("Intermediate")) {

            return """
                    Intermediate DSA Plan (30 Days)

                    Week 1:
                    - Arrays Advanced
                    - Sliding Window

                    Week 2:
                    - Linked List
                    - Stack
                    - Queue

                    Week 3:
                    - Trees
                    - BST

                    Week 4:
                    - Graphs
                    - Dynamic Programming
                    """;
        }

        return """
                Advanced DSA Plan

                - Graph Algorithms
                - DP Advanced
                - Segment Trees
                - Tries
                - Competitive Programming
                """;
    }
}