package com.example.orderstatusservice.listener;

import com.example.orderstatusservice.dto.OrderStatus;
import com.example.orderstatusservice.dto.Status;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.UUID;

@Component
@Slf4j
@RequiredArgsConstructor
public class KafkaMessageListener
{
    @Value("${app.kafka.kafkaMessageProduceTopic}")
    private String topic;
    private final KafkaTemplate<String, OrderStatus> kafkaTemplate;

    @KafkaListener(
            topics = "${app.kafka.kafkaMessageConsumeTopic}",
            groupId = "${app.kafka.kafkaMessageGroupId}",
            containerFactory = "kafkaMessageConcurrentKafkaListenerContainerFactory"
    )
    public void listen() {
        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setDate(Instant.now());
        orderStatus.setStatus(orderStatus.getDate().toEpochMilli() % 2 == 0 ? Status.CREATED : Status.PROCESS);
        kafkaTemplate.send(topic, UUID.randomUUID().toString(), orderStatus);
    }
}
