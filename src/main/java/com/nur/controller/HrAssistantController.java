package com.nur.controller;

import com.nur.services.HrAIAssistantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hr/api")
@RequiredArgsConstructor
public class HrAssistantController {

    private final HrAIAssistantService hrAssistantService;

    @GetMapping("/ask")
    public String askHr(@RequestParam String question) {
        return hrAssistantService.askHrQuestion(question);
    }
}
