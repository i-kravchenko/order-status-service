package com.example.orderstatusservice.dto;

import lombok.Data;

@Data
public class OrderEvent
{
    private String product;
    private Integer quantity;
}
