package com.activemq.service;

import com.activemq.model.MyObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageProducer {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    // Convert object to json message and publish
    public void sendTo(String destination, MyObject object) {
        try {
            String jsonMessage = objectMapper.writeValueAsString(object);
            jmsTemplate.convertAndSend(destination, jsonMessage);
        }
        catch (Exception e) {
            throw new RuntimeException("Error sending message", e);
        }
        log.info("Producer Message Sent");
    }
}
