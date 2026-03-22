package com.nur.services;

import com.nur.dtos.OrderStatusResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderSupportAIAssistantService {

    @Value("classpath:prompts/order_user_template.st")
    private Resource orderUserPrompt;

    @Value("classpath:prompts/order_system_policy.st")
    private Resource orderSystemPolicyPrompt;

    private final ChatClient geminiChatClient;


    public String talkToAISupport(String customerName, String orderId, String customerMessage) {
        return geminiChatClient
                .prompt()
                .system(orderSystemPolicyPrompt)
                .user(promptUserSpec -> promptUserSpec.text(orderUserPrompt)
                        .param("customerName", customerName)
                        .param("orderId", orderId)
                        .param("customerMessage", customerMessage))
                .call()
                .content();
    }

    public OrderStatusResponse getOrderStatus(String orderId, String customerMessage) {

        return geminiChatClient
                .prompt()
                .system("""
                    You are an Order Status API.

                    Return ONLY JSON:
                    {
                      "orderId": "string",
                      "status": "Processing | Shipped | Delivered | Delayed | Cancelled",
                      "estimatedDelivery": "YYYY-MM-DD or UNKNOWN"
                    }

                    No explanation. No extra text.
                """)
                .user("""
                    Order ID: %s
                    Customer message: %s
                """.formatted(orderId, customerMessage))
                .call()
                .entity(OrderStatusResponse.class);
    }

}
