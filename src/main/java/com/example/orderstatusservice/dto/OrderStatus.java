package com.example.orderstatusservice.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class OrderStatus
{
    private Status status;
    private Instant date;
}
