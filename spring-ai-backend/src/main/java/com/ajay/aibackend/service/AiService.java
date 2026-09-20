package com.ajay.aibackend.service;

import com.ajay.aibackend.dto.InterviewRequest;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class AiService {
    private final ChatClient chatClient;

    public AiService(ChatClient.Builder builder) {
        this.chatClient = builder
                .defaultSystem("You are a senior Java backend interviewer. Give accurate, practical and interview-ready answers. Prefer simple explanations, examples and production considerations.")
                .build();
    }

    public String chat(String message) {
        return chatClient.prompt()
                .user(message)
                .call()
                .content();
    }

    public String generateInterview(InterviewRequest request) {
        String prompt = "Create " + request.count() + " interview questions for a " +
                request.experienceLevel() + " developer on " + request.topic() + ". " +
                "For each question include: question, what the interviewer expects, and a concise model answer. " +
                "Mix conceptual and scenario-based questions.";
        return chat(prompt);
    }
}
