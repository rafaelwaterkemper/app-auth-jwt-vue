package com.waterkemper.springsecurityjwt.activemq;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Topic;

@Component
public class ProducerTopic {


    private final JmsTemplate jmsTemplate;
    private final Topic topic = new ActiveMQTopic("pedido");

    public ProducerTopic(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessage(Object payload) {
        jmsTemplate.convertAndSend(topic, payload);
    }

}
