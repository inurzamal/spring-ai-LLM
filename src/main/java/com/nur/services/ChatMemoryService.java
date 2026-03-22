package com.nur.services;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.stereotype.Service;
import static org.springframework.ai.chat.memory.ChatMemory.CONVERSATION_ID;

@Service
@RequiredArgsConstructor
public class ChatMemoryService {

    private final ChatClient geminiChatClient;
    private final ChatMemory chatMemory;

    public String testChatMemory(String conversationId, String question) {

        return geminiChatClient
                .prompt()
                .advisors(MessageChatMemoryAdvisor.builder(chatMemory)
                        .conversationId(conversationId)
                        .build())
                .user(question)
                .call()
                .content();
    }

    public String askWithMemory(String conversationId, String question) {

        return geminiChatClient
                .prompt()
                .advisors(spec -> spec.param(CONVERSATION_ID, conversationId))
                .user(question)
                .call()
                .content();
    }
}
