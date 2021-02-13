//package com.waterkemper.springsecurityjwt.api;
//
//import com.waterkemper.springsecurityjwt.activemq.ProducerQueue;
//import com.waterkemper.springsecurityjwt.activemq.ProducerTopic;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/test")
//public class TestAuthorization {
//
//    private final ProducerTopic producerTopic;
//    private final ProducerQueue producerQueue;
//
//    public TestAuthorization(ProducerTopic producerTopic,
//                             ProducerQueue producerQueue) {
//        this.producerTopic = producerTopic;
//        this.producerQueue = producerQueue;
//    }
//
//    @GetMapping("/all")
//    public String allAccess() {
//        return "Public Content.";
//    }
//
//    @PostMapping("/topic")
//    public ResponseEntity publicaTopic() {
//        producerTopic.sendMessage("Olá mundo Topic");
//        return ResponseEntity.ok().build();
//    }
//
//    @PostMapping("/queue")
//    public ResponseEntity publicaQueue() {
//        producerQueue.sendMessage("Olá mundo Queu");
//        return ResponseEntity.ok().build();
//    }
//
//    @GetMapping("/user")
//    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
//    public String userAccess() {
//        return "User Content.";
//    }
//
//    @GetMapping("/mod")
//    @PreAuthorize("hasRole('MODERATOR')")
//    public String moderatorAccess() {
//        return "Moderator Board.";
//    }
//
//    @GetMapping("/admin")
//    @PreAuthorize("hasRole('ADMIN')")
//    public ResponseEntity adminAccess() {
//        return ResponseEntity.ok().build();
//    }
//}