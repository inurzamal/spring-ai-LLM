package com.nur.controller;

import com.nur.services.ChatMemoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "Chat Memory", description = "Endpoints to interact with chat memory")
public class ChatMemoryController {

    private final ChatMemoryService chatMemoryService;

    @GetMapping("/discuss")
    @Operation(description = "Maintains chat history using a provided conversationId.")
    public String discuss(
            @RequestParam String conversationId,
            @RequestParam String question) {

        return chatMemoryService.testChatMemory(conversationId, question);
    }

    @GetMapping("/ask-with-memory")
    @Operation(description = "Maintains chat history based on userId from request header.")
    public String askWithMemory(@RequestHeader("userId") String userId, @RequestParam String question) {
        return chatMemoryService.askWithMemory(userId, question);
    }
}
