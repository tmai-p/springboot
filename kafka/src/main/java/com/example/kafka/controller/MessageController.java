package com.example.kafka.controller;

import com.example.kafka.model.MessageRequest;
import com.example.kafka.service.KafkaProducerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/message")
public class MessageController {

    private KafkaProducerService kafkaProducerService;

    public MessageController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @PostMapping("/produce")
    public String publish(@RequestBody MessageRequest request) {
        kafkaProducerService.send(request.message());
        return "Message sent Successfully to the Kafka topic.";
    }
}
