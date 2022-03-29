package com.wit.restModule.services;

import com.wit.libDataDtoChangelle.dto.AbstractDataDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQService implements IRabbitMQService {

    protected RabbitTemplate rabbitTemplate;

    public RabbitMQService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String queueName, Object message) {
        this.rabbitTemplate.convertAndSend(queueName, message);
    }

    public AbstractDataDTO getMessagem(String queueName) {
        return (AbstractDataDTO) this.rabbitTemplate.receiveAndConvert(queueName);
    }

}
