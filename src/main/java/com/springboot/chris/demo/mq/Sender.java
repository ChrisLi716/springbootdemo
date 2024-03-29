package com.springboot.chris.demo.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Sender {

	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	public void send() {
		String msg = "hello " + new Date();
		rabbitTemplate.convertAndSend("hello-chris-queue", msg);
	}
	
}
