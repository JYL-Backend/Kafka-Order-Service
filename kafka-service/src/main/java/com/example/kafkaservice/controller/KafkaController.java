package com.example.kafkaservice.controller;

import com.example.kafkaservice.service.Producer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
@RequiredArgsConstructor
public class KafkaController {
    private final Producer producer;

    @PostMapping
    public String sendMessage(@RequestParam("message") String message){
        this.producer.sendMessage(message);
        return "success";
    }

}
