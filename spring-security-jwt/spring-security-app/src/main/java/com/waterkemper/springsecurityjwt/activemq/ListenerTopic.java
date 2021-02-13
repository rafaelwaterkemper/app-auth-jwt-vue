//package com.waterkemper.springsecurityjwt.activemq;
//
//import com.waterkemper.springsecurityjwt.model.Pessoa;
//import com.waterkemper.springsecurityjwt.model.Sexo;
//import com.waterkemper.springsecurityjwt.repositories.PessoaRepository;
//import org.apache.activemq.command.ActiveMQMessage;
//import org.springframework.jms.annotation.JmsListener;
//import org.springframework.jms.core.JmsTemplate;
//import org.springframework.messaging.handler.annotation.Header;
//import org.springframework.messaging.handler.annotation.Headers;
//import org.springframework.stereotype.Component;
//
//import javax.jms.JMSException;
//import javax.jms.Session;
//import javax.jms.TextMessage;
//import java.time.LocalDate;
//import java.util.Map;
//
//@Component
//public class ListenerTopic {
//
//    private final PessoaRepository pessoaRepository;
//    private final JmsTemplate jmsTemplate;
//
//    public ListenerTopic(PessoaRepository pessoaRepository,
//                         JmsTemplate jmsTemplate) {
//        this.pessoaRepository = pessoaRepository;
//        this.jmsTemplate = jmsTemplate;
//    }
//
//    //    @JmsListener(destination = "pedido", id = "subs", subscription = "pedido1", containerFactory = "myFactory")
////    public void onMessage() {
////        System.out.println("Caiu no pedido 1");
////        throw new RuntimeException("Testando redelivery");
////    }
//
////    @JmsListener(destination = "pedido", containerFactory = "myFactorySecond", subscription = "pedido1")
////    public void onMessageDois(TextMessage message) {
////        System.out.println("Caiu no pedido 2");
////    }
////
////    @JmsListener(destination = "pedido")
////    public void onMessageQueue(TextMessage message, @Header(value = "JMSXDeliveryCount", defaultValue = "1") int count) throws JMSException {
////        System.out.println("Caiu na queue, count " + count);
////        Pessoa pessoa = new Pessoa();
////        pessoa.setNome("Nova criação");
////        pessoa.setDataNascimento(LocalDate.now());
////        pessoa.setSexo(Sexo.MASCULINO);
////
////        pessoaRepository.save(pessoa);
////        throw new RuntimeException("Testando redelivery");
////    }
//
//    @JmsListener(destination = "taskmanager.createTaskQueue", selector = "system_target = 'RAFA'")
//    public void onMessageQueue(TextMessage message, Session session, @Headers Map<String, Object> headers, @Header(value = "JMSXDeliveryCount", defaultValue = "1") int count) throws JMSException {
//        System.out.println(message.getText());
////        message.setStr
//        jmsTemplate.convertAndSend(((ActiveMQMessage) message).getDestination().getPhysicalName(), message.getText(), (mes) -> {
//            mes.setLongProperty("DATABASE_ID", (Long) headers.get("DATABASE_ID"));
//            mes.setLongProperty("ENTIDADE_ID", (Long) headers.get("ENTIDADE_ID"));
//            mes.setLongProperty("SYSTEM_ID", (Long) headers.get("SYSTEM_ID"));
//            mes.setStringProperty("USER_ID", (String) headers.get("USER_ID"));
//            mes.setStringProperty("usuario", "k8s");
//            mes.setStringProperty("system_target", "FOLHA");
//            return mes;
//        });
//    }
//}
//
