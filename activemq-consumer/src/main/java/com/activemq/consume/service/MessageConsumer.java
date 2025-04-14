package com.activemq.consume.service;

import com.activemq.consume.model.MyObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @JmsListener(
            destination = "${activemq.source.queue}",
            concurrency = "2-5"
    )
    public void listener(String message) {
        System.out.println("Listener received message: " + message);

        try {
            MyObject ob = jsonToObject(message);
            System.out.println("/* 1 **************************/");
            System.out.println(" Field1 = " + ob.field1());
            System.out.println(" Field2 = " + ob.field2());
            System.out.println(" Field3 = " + ob.field3());
            System.out.println("/***************************/");
        }
        catch (JsonProcessingException e) {
            System.out.println("JsonProcessException: " + e.getMessage());
        }

    }

    private MyObject jsonToObject(String jsonMessage) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        MyObject retObj = mapper.readValue(jsonMessage, MyObject.class);
        return retObj;
    }
}
