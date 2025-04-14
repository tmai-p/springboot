package com.activemq.controller;

import com.activemq.model.MyObject;
import com.activemq.service.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MessageController {

    @Autowired private JmsTemplate jmsTemplate;

    @Autowired MessageProducer messageProducer;

    @Value("${activemq.destination}")
    private String destination;

    /**
    * API for publish message for ActiveMQ queue
    */
    @PostMapping("/publish")
    public String publishMessage(@RequestBody MyObject object){
        messageProducer.sendTo(destination, object);
        return "Success";
    }
}
