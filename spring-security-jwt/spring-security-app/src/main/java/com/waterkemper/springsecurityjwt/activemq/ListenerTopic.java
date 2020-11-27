package com.waterkemper.springsecurityjwt.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.TextMessage;

@Component
public class ListenerTopic {

    @JmsListener(destination = "pedido", id = "subs", subscription = "pedido1", containerFactory = "myFactory")
    public void onMessage() {
        System.out.println("Caiu no pedido 1");
    }

    @JmsListener(destination = "pedido", containerFactory = "myFactorySecond", subscription = "pedido1")
    public void onMessageDois(TextMessage message) {
        System.out.println("Caiu no pedido 2");
    }

    @JmsListener(destination = "pedido")
    public void onMessageQueue(TextMessage message) {
        System.out.println("Caiu na queue");

    }
}
