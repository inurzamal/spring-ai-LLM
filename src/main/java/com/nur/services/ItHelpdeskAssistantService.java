package com.nur.services;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItHelpdeskAssistantService {

    // You can switch this to OpenAI or Ollama anytime
    private final ChatClient geminiChatClient;

    private static final SystemMessage SYSTEM_POLICY = new SystemMessage("""
        You are an IT Helpdesk Assistant for an enterprise organization.

        RESPONSIBILITIES:
        - Answer only IT support related questions.
        - Topics allowed: software issues, hardware issues, VPN, email, system access, passwords, tools.
        - Provide clear step-by-step troubleshooting.

        STRICT RULES:
        - Do NOT answer personal questions.
        - Do NOT answer HR, payroll, salary, appraisal, or medical questions.
        - Do NOT generate or infer personal or confidential data.
        - Do NOT suggest bypassing security controls.

        OUT-OF-SCOPE HANDLING:
        - If the question is not IT-related, respond exactly with:
          "I can help only with IT-related support questions."

        TONE:
        - Professional
        - Clear
        - Helpful
        """);

    public String assist(String userQuestion) {

        List<Message> messages = List.of(
                SYSTEM_POLICY,
                new UserMessage(userQuestion)
        );

        Prompt prompt = new Prompt(messages);

        return geminiChatClient
                .prompt(prompt)
                .call()
                .content();
    }
}
