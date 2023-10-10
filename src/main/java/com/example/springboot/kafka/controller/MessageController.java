package com.example.springboot.kafka.controller;

import com.example.springboot.kafka.kafka.KafkaProducer;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {
    private KafkaProducer producer;

    public MessageController(KafkaProducer producer) {
        this.producer = producer;
    }

    //http://localhost:8080/api/v1/kafka/publish?message=helloworld
    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message) {
        producer.sendMessage(message);
        return ResponseEntity.ok("Message sent to the topic");
    }
}
