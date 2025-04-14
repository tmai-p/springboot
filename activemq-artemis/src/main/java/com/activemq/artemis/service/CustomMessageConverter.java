package com.activemq.artemis.service;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.Session;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.SimpleMessageConverter;

/*
A custom message converter that implements the MessageConverter interface.
This converter will handle the conversion of messages to and from specific object types.
 */
public class CustomMessageConverter implements MessageConverter {

    private final SimpleMessageConverter delegate = new SimpleMessageConverter();

    @Override
    public Message toMessage(Object object, Session session)
            throws JMSException, MessageConversionException {
        // Add custom conversion logic if needed
        return delegate.toMessage(object, session);
    }

    @Override
    public Object fromMessage(Message message)
            throws JMSException, MessageConversionException {
        // Add custom conversion logic if needed
        return delegate.fromMessage(message);
    }
}
