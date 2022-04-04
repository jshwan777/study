package com.study.kafkastudy.test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	//KafkaConfiguration에서 작성한 Bean 주입 
	@Autowired
	KafkaTemplate kafkaTemplate;
	
	@RequestMapping(value="/get")
	public String getData(@RequestParam(value="message",required = true, defaultValue = "") String message) {
		
		//현재시간
		LocalDateTime date = LocalDateTime.now();
		String dateStr = date.format(fmt);
		
		//생성된 토픽에 메시지+현재시간 넣기
		kafkaTemplate.send("testtopic",dateStr+"	"+message);
		
		return "kafkaTemplate.send >> "+message;
	}

}
