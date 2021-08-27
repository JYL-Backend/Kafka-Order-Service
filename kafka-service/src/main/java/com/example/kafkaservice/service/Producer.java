package com.example.kafkaservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Producer {
    private static final String TOPIC = "quickstart-events";
    private final KafkaTemplate<String,String> kafkaTemplate;

    public void sendMessage(String message){
        System.out.println("Send message = " + message);
        this.kafkaTemplate.send(TOPIC, message);
    }
}
