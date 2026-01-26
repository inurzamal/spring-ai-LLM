package com.nur.controller;

import com.nur.services.ItHelpdeskAssistantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/helpdesk")
@RequiredArgsConstructor
public class ItHelpdeskAssistantController {

    private final ItHelpdeskAssistantService assistantService;

    @GetMapping("/ask")
    public String ask(@RequestParam String question) {
        return assistantService.assist(question);
    }
}

