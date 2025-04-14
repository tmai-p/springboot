package com.activemq.artemis.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/*
To receive messages from the broker,
this listener will use the DefaultJmsListenerContainerFactory
that we configured in the ArtemisConfig.
 */
@Component
public class MessageListener {

    @JmsListener(destination = "${artemis.queue}", concurrency = "2-5")
    public void listener_1(String message) {
        System.out.println("1. Received message: " + message);
        // Additional business logic can be added here
    }
}
