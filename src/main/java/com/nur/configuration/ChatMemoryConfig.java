package com.nur.configuration;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatMemoryConfig {

//    @Bean
//    public ChatMemory chatMemory() {
//        // We use a Repository to store the actual bits in RAM
//        // And a ChatMemory implementation to define HOW many messages to remember
//        return MessageWindowChatMemory.builder()
//                .chatMemoryRepository(new InMemoryChatMemoryRepository())
//                .maxMessages(10) // Remembers the last 10 messages
//                .build();
//    }

}