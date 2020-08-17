package com;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private  KafkaTemplate<String, SimpleMessage> kafkaTemplate=null;
    private static final org.slf4j.Logger log = 
			org.slf4j.LoggerFactory.getLogger(KafkaProducer.class);

    @Value("${topic.name}")
    private String topicName;

    public void send(SimpleMessage message) {
        this.kafkaTemplate.send(topicName, message);
        log.info("Published the message [{}] to the kafka queue: [{}]",
                message.getBody(),
                topicName
        );
    }

	public KafkaProducer(KafkaTemplate<String, SimpleMessage> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}
    
    
    
}
