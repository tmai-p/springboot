package com.apache.kafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @KafkaListener(topics = "MY-KAFKA-TOPIC", groupId = "my-consumer-group-id")
    public void consumeMessage(String message) {
        System.out.println("Received message: " + message);
    }
}
