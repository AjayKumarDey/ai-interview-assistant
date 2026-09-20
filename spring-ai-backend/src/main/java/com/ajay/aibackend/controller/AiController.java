package com.ajay.aibackend.controller;

import com.ajay.aibackend.dto.AiResponse;
import com.ajay.aibackend.dto.ChatRequest;
import com.ajay.aibackend.dto.InterviewRequest;
import com.ajay.aibackend.service.AiService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ai")
public class AiController {
    private final AiService aiService;

    public AiController(AiService aiService) {
        this.aiService = aiService;
    }

    @PostMapping("/chat")
    public ResponseEntity<AiResponse> chat(@Valid @RequestBody ChatRequest request) {
        return ResponseEntity.ok(new AiResponse(aiService.chat(request.message())));
    }

    @PostMapping("/interview")
    public ResponseEntity<AiResponse> interview(@Valid @RequestBody InterviewRequest request) {
        return ResponseEntity.ok(new AiResponse(aiService.generateInterview(request)));
    }
}
