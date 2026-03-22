package com.nur.controller;

import com.nur.services.MultiModelChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/multi-model/api")
@RequiredArgsConstructor
public class MultiModelChatController {

    private final MultiModelChatService multiModelChatService;

    @GetMapping("/chat/openai")
    public String chatWithOpenAI(@RequestParam("message") String message) {
        return multiModelChatService.chatWithOpenAI(message);
    }

    @GetMapping("/chat/gemini")
    public String chatWithGemini(@RequestParam("message") String message) {
        return multiModelChatService.chatWithGemini(message);
    }

    @GetMapping("/chat/ollama")
    public String chatWithOllama(@RequestParam("message") String message) {
        return multiModelChatService.chatWithOllama(message);
    }
}