package com.nur.configuration;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.client.advisor.api.Advisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.google.genai.GoogleGenAiChatModel;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Configuration
public class ChatAIConfiguration {

    @Bean
    public ChatClient openAiChatClient(OpenAiChatModel openAiChatModel) {
        return ChatClient.builder(openAiChatModel).build();
    }

//    @Bean
//    @Primary
//    public ChatClient geminiChatClient(GoogleGenAiChatModel googleGenAiChatModel) {
//        return ChatClient.builder(googleGenAiChatModel).build();
//    }

    @Bean
    @Primary
    public ChatClient geminiChatClient(GoogleGenAiChatModel googleGenAiChatModel, ChatMemory chatMemory) {

        Advisor loggerAdvisor = new SimpleLoggerAdvisor();

        Advisor memoryAdvisor = MessageChatMemoryAdvisor
                .builder(chatMemory)
                .build();

        return ChatClient.builder(googleGenAiChatModel)
                .defaultAdvisors(List.of(memoryAdvisor, loggerAdvisor))
                .build();
    }


    @Bean
    public ChatClient ollamaChatClient(OllamaChatModel ollamaChatModel) {
        return ChatClient.builder(ollamaChatModel).build();
    }

}