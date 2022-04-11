package com.study.kafkastudy.test.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class kafkaConsumerService {
	
	@KafkaListener(topics = "testtopic", groupId = "testGroup")
	public void consumer(String message)  {
		System.out.println("## consumer에서 출력하는 message :: "+message);
	}
}
