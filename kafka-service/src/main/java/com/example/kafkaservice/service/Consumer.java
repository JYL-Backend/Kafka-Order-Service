package com.example.kafkaservice.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Consumer {
    @KafkaListener(topics = "quickstart-events", groupId = "con")
    public void consume(String message) throws IOException {
        System.out.println("rcv message = " + message);
    }
}
