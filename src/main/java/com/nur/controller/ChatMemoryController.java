package com.nur.controller;

import com.nur.services.ChatMemoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChatMemoryController {

    private final ChatMemoryService chatMemoryService;

    @GetMapping("/discuss")
    public String discuss(
            @RequestParam String conversationId,
            @RequestParam String question) {

        return chatMemoryService.testChatMemory(conversationId, question);
    }

    @GetMapping("/ask-with-memory")
    public String askWithMemory(@RequestHeader("userId") String userId, @RequestParam String question) {
        return chatMemoryService.askWithMemory(userId, question);
    }
}
