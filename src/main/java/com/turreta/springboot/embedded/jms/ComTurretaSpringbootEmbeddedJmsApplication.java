package com.turreta.springboot.embedded.jms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class ComTurretaSpringbootEmbeddedJmsApplication {

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = SpringApplication.run(ComTurretaSpringbootEmbeddedJmsApplication.class, args);

		MessageSender msgSender = (MessageSender)ctx.getBean("messageSender");

		// Send message to a JMS queue
		msgSender.sendMessage("This is the first msg \n");

		// Give it some time to process
		TimeUnit.MINUTES.sleep(2);
	}
}
