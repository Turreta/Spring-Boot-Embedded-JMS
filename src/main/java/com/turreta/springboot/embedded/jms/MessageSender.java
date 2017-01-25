package com.turreta.springboot.embedded.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

@Component
public class MessageSender {
    @Autowired
    JmsTemplate jmsTemplate;

    public void sendMessage(final String text) {

        jmsTemplate.send(new MessageCreator(){
            @Override
            public Message createMessage(Session session) throws JMSException{
                ObjectMessage objectMessage = session.createObjectMessage(text);
                return objectMessage;
            }
        });
    }
}
