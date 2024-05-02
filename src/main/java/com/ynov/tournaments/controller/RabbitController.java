package com.ynov.tournaments.controller;

import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import com.rabbitmq.client.ConnectionFactory;
//import com.rabbitmq.client.Connection;
//import com.rabbitmq.client.Channel;

@RestController
@RequestMapping("/api/v1")
public class RabbitController {
    private final static String QUEUE_NAME = "test";

    @GetMapping("/rabbit")
    public void  getServer() {
//        ConnectionFactory factory = new ConnectionFactory();
//        factory.setHost("localhost");
//        factory.setPort(5672);
//        factory.setUsername("llele");
//        factory.setPassword("admin");
//        try (Connection connection = factory.newConnection();
//             Channel channel = connection.createChannel()) {
//            // Create a channel
//            // Use the channel to interact with RabbitMQ (e.g., declare queues, publish messages, etc.)
//            channel.queueDeclare(QUEUE_NAME, true,false,false,null);
//            String message = "Hello World! i am Tournaments";
//            channel.basicPublish("ok", QUEUE_NAME, null, message.getBytes());
//            System.out.println(" [x] Sent '" + message + "'");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } catch (TimeoutException e) {
//            throw new RuntimeException(e);
//        }
    }
}
