package com.example.kafkaservice.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class ProducerTests {
    @Autowired
    private Producer producer;
    @Test
    public void testProducer(){
        //given
        producer.sendMessage("fsdgds");
        //when

        //then
    }
}
