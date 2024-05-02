package com.ynov.tournaments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@SpringBootApplication
public class TournamentsApplication {

	public static void main(String[] args) {

//		ConnectionFactory factory = new ConnectionFactory();
//		factory.setHost("localhost");
//		factory.setPort(5672);
//		factory.setUsername("llele");
//		factory.setPassword("admin");
//		Connection connection = null;
//		try {
//			connection = factory.newConnection();
//		} catch (IOException e) {
//			throw new RuntimeException(e);
//		} catch (TimeoutException e) {
//			throw new RuntimeException(e);
//		}
//		Channel channel = null;
//		try {
//			channel = connection.createChannel();
//		} catch (IOException e) {
//			throw new RuntimeException(e);
//		}
//
//		try {
//			channel.exchangeDeclare("ok", "fanout");
//		} catch (IOException e) {
//			throw new RuntimeException(e);
//		}
//		String queueName = "test";
//
//		try {
//			channel.queueBind(queueName, "", "");
//		} catch (IOException e) {
//			throw new RuntimeException(e);
//		}
//
//		System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
//
//		DeliverCallback deliverCallback = (consumerTag, delivery) -> {
//			String message = new String(delivery.getBody(), "UTF-8");
//			System.out.println(" [x] Received '" + message + "'");
//		};
//		try {
//			channel.basicConsume(queueName, true, deliverCallback, consumerTag -> { });
//		} catch (IOException e) {
//			throw new RuntimeException(e);
//		}

		SpringApplication.run(TournamentsApplication.class, args);
		System.out.print("Hello world");
	}
	
	@Bean
	public CommonsRequestLoggingFilter requestLoggingFilter() {
		CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
		loggingFilter.setIncludeClientInfo(true);
		loggingFilter.setIncludeQueryString(true);
		loggingFilter.setIncludePayload(true);
		loggingFilter.setIncludeHeaders(true);
		loggingFilter.setMaxPayloadLength(64000);
		return loggingFilter;
	}

}
