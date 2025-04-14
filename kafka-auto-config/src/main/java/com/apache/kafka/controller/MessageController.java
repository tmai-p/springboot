package com.apache.kafka.controller;

import com.apache.kafka.service.KafkaProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private final KafkaProducer kafkaProducer;

    public MessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/api/v1/send")
    public void sendMessageToKafka(@RequestBody String message) {
        kafkaProducer.sendMessage(message);
    }
}
