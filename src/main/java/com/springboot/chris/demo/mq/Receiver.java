package com.springboot.chris.demo.mq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
	
	@RabbitListener(queues = "hello-chris-queue")
	public void process(String msg) {
		System.out.println("reciver:" + msg);
	}
}
