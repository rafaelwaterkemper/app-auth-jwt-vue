package com.waterkemper.springsecurityjwt.activemq;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

@Component
public class ProducerQueue {


    private final JmsTemplate jmsTemplate;
    private final Queue queue = new ActiveMQQueue("pedido");

    public ProducerQueue(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessage(Object payload) {
        jmsTemplate.convertAndSend(queue, payload);
    }

}
