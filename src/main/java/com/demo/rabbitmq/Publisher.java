package com.demo.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Publisher {

  public static void main(String[] args) throws IOException, TimeoutException {
    ConnectionFactory connectionFactory = new ConnectionFactory();
    Connection connection = connectionFactory.newConnection();
    Channel channel = connection.createChannel();

    String message = "My first message from RabbitMQ";

    channel.basicPublish("", "Queue-1", null, message.getBytes());

    channel.close();
    connection.close();
  }

}
