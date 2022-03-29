package com.wit.restModule.services;

import com.wit.libDataDtoChangelle.dto.AbstractDataDTO;

public interface IRabbitMQService {
    public void sendMessage(String queueName, Object message);

    public AbstractDataDTO getMessagem(String queueName);
}
