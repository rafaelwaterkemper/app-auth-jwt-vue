//package com.waterkemper.springsecurityjwt.activemq;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.apache.activemq.ActiveMQConnectionFactory;
//import org.apache.activemq.pool.PooledConnectionFactory;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
//import org.springframework.boot.autoconfigure.jms.JmsProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
//import org.springframework.jms.config.JmsListenerContainerFactory;
//import org.springframework.jms.core.JmsTemplate;
//import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
//import org.springframework.jms.support.converter.MessageConverter;
//import org.springframework.jms.support.converter.MessageType;
//
//import javax.jms.ConnectionFactory;
//import javax.jms.Session;
//
//@Configuration
//public class ActiveMqAutoConfiguration {
//
//    @Bean
//    public ConnectionFactory connectionFactory() {
//        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("failover:(tcp://localhost:61616)");
//        PooledConnectionFactory pooledConnectionFactory = new PooledConnectionFactory(connectionFactory);
//        pooledConnectionFactory.setMaxConnections(2);
//        return pooledConnectionFactory;
//    }
//
//    @Bean
//    public ConnectionFactory connectionFactorySecond() {
//        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("failover:(tcp://localhost:61616)");
//        PooledConnectionFactory pooledConnectionFactory = new PooledConnectionFactory(connectionFactory);
//        pooledConnectionFactory.setMaxConnections(1);
//        return pooledConnectionFactory;
//    }
//
////    @Bean
////    public ConnectionFactory connectionFactorySecond() {
////        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("failover:(tcp://localhost:61616)");
////        PooledConnectionFactory pooledConnectionFactory = new PooledConnectionFactory(connectionFactory);
////        pooledConnectionFactory.setMaxConnections(1);
////        return pooledConnectionFactory;
////    }
//
//    @Bean
//    public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory,
//                                                    DefaultJmsListenerContainerFactoryConfigurer configurer) {
//        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
//        // This provides all boot's default to this factory, including the message converter
//        configurer.configure(factory, connectionFactory);
////        factory.setPubSubDomain(true);
//        factory.setClientId("teste2");
//        factory.setSubscriptionDurable(true);
//
//        // You could still override some of Boot's default if necessary.
//        return factory;
//    }
//
////    @Bean
////    public JmsListenerContainerFactory<?> myFactorySecond(@Qualifier("connectionFactorySecond") ConnectionFactory connectionFactory,
////                                                    DefaultJmsListenerContainerFactoryConfigurer configurer) {
////        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
////        // This provides all boot's default to this factory, including the message converter
////        configurer.configure(factory, connectionFactory);
////        factory.setPubSubDomain(true);
////        factory.setClientId("teste");
////        factory.setSubscriptionDurable(true);
////
////        // You could still override some of Boot's default if necessary.
////        return factory;
////    }
//
//
//    @Bean // Serialize message content to json using TextMessage
//    public MessageConverter jacksonJmsMessageConverter(ObjectMapper objectMapper) {
//        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
//        converter.setTargetType(MessageType.TEXT);
//        converter.setObjectMapper(objectMapper);
//        converter.setTypeIdPropertyName("_type");
//        return converter;
//    }
//
//    @Bean
//    public JmsTemplate jmsTemplate(ConnectionFactory containerFactory) {
//        JmsTemplate jmsTemplate = new JmsTemplate(containerFactory);
//        jmsTemplate.setSessionTransacted(true);
//        jmsTemplate.setDeliveryMode(2);
//        return jmsTemplate;
//    }
//
//}
