package com.nur.services;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MultiModelChatService {

    private final ChatClient openAiChatClient;
    private final ChatClient ollamaChatClient;
    private final ChatClient geminiChatClient;

    public String chatWithOpenAI(String message) {
        return openAiChatClient.prompt(message).call().content();
    }

    public String chatWithGemini(String message) {
        return geminiChatClient.prompt(message).call().content();
    }

    public String chatWithOllama(String message) {
        return ollamaChatClient.prompt(message).call().content();
    }
}
