package com;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class KafkaSender {

    private  KafkaProducer kafkaProducer=null;

    @PostMapping("send")
    public void sendData(@RequestBody SimpleMessage message) {
        this.kafkaProducer.send(message);
    }

	public KafkaSender(KafkaProducer kafkaProducer) {
		super();
		this.kafkaProducer = kafkaProducer;
	}
    
    
    
}
