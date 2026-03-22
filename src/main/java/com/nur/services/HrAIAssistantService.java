package com.nur.services;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.nio.file.Files;

@Service
@RequiredArgsConstructor
public class HrAIAssistantService {

    @Value("classpath:prompts/hr_system_policy.st")
    private Resource hrSystemPolicy;

    @Value("classpath:prompts/hr_user_prompt.st")
    private Resource hrUserPrompt;

    @Value("classpath:hr-policy.txt")
    private Resource hrPolicyFile;

    private final ChatClient geminiChatClient;

    private String cachedPolicy;

    @PostConstruct
    void loadPolicyAtStartup() {
        try {
            this.cachedPolicy = Files.readString(hrPolicyFile.getFile().toPath());
        } catch (Exception e) {
            throw new IllegalStateException("Failed to load HR policy", e);
        }
    }

    public String askHrQuestion(String question) {
        return geminiChatClient
                .prompt()
                .system(hrSystemPolicy)
                .user(user -> user.text(hrUserPrompt)
                        .param("policy", cachedPolicy)
                        .param("question", question))
                .call()
                .content();
    }
}
