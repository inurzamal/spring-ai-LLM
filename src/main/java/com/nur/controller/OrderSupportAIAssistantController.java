package com.nur.controller;

import com.nur.dtos.OrderStatusResponse;
import com.nur.services.OrderSupportAIAssistantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OrderSupportAIAssistantController {

    private final OrderSupportAIAssistantService aiAssistantService;

    @GetMapping("/order-ai-support")
    public String talkToOrderAISupport(@RequestParam String customerName, @RequestParam String orderId,@RequestParam String customerMessage) {
        return aiAssistantService.talkToAISupport(customerName, orderId, customerMessage);
    }

    @GetMapping("/order-status-structured")
    public OrderStatusResponse getStatus(
            @RequestParam String orderId,
            @RequestParam String message) {

        return aiAssistantService.getOrderStatus(orderId, message);
    }
}
