package com.nur.configuration;

import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.InMemoryChatMemoryRepository;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatMemoryConfig {

    @Bean
    public ChatMemory chatMemory() {
        // We use a Repository to store the actual bits in RAM
        // And a ChatMemory implementation to define HOW many messages to remember
        return MessageWindowChatMemory.builder()
                .chatMemoryRepository(new InMemoryChatMemoryRepository())
                .maxMessages(10) // Remembers the last 10 messages
                .build();
    }
}