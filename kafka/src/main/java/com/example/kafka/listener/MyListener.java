package com.example.kafka.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MyListener {

    @KafkaListener(
            topics = "Choch-topic",
            groupId = "choch-group-id"
    )

    void listener(String data) {
        System.out.println("Listener receiving: " + data);
    }

}
