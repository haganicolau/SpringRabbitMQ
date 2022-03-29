package com.wit.engineModule.services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQService {

    private RabbitTemplate rabbitTemplate;

    public RabbitMQService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String queueName, Object message) {
        this.rabbitTemplate.convertAndSend(queueName, message);
    }
}
