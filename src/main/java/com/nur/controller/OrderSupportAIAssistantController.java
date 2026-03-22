package com.nur.controller;

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
}
