package com;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

	private static final org.slf4j.Logger log = 
			org.slf4j.LoggerFactory.getLogger(KafkaConsumer.class);
    @KafkaListener(topics = "${topic.name}")
    public void receive(SimpleMessage consumerMessage) {
        log.info("Received message from kafka queue: {}", consumerMessage.getBody());
    }
}
