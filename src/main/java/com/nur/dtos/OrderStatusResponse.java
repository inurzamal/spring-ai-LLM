package com.nur.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderStatusResponse {

    private String orderId;
    private String status;
    private String estimatedDelivery;
}