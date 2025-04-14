package com.activemq.artemis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
REST controller
will be using the JmsTemplate to send messages to the specified queue.
 */
@RestController
public class MessageController {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("${artemis.queue}")
    private String queue;

    @PostMapping("/api/v1/send")
    @Transactional
    public String sendMessage(@RequestParam String message) {
        jmsTemplate.convertAndSend(queue, message);
        return "Message sent!";
    }
}
