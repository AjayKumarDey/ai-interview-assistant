package com.ajay.aibackend.dto;

import jakarta.validation.constraints.NotBlank;

public record InterviewRequest(
        @NotBlank String topic,
        @NotBlank String experienceLevel,
        Integer questionCount) {
    public int count() {
        return questionCount == null ? 5 : Math.min(Math.max(questionCount, 1), 20);
    }
}
