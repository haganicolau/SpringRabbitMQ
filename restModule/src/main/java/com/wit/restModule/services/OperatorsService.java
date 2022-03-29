package com.wit.restModule.services;

import com.wit.libDataDtoChangelle.consts.RabbitMQConsts;
import com.wit.libDataDtoChangelle.dto.OperatorsDTO;
import com.wit.libDataDtoChangelle.dto.ResponseDTO;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperatorsService {
    @Autowired
    private final IRabbitMQService rabbitMQService;

    public OperatorsService(RabbitMQService rabbitMQService) {
        this.rabbitMQService = rabbitMQService;
    }

    public ResponseDTO sendMessageOperator(OperatorsDTO dto) {
        dto.setRequestId(MDC.get("requestId"));
        this.rabbitMQService.sendMessage(RabbitMQConsts.QUEUE_CALCULATE, dto);
        ResponseDTO response = null;

        do {
            response = (ResponseDTO) this.rabbitMQService.getMessagem(RabbitMQConsts.QUEUE_RESPONSE);
        } while (null == response);

        return response;
    }

}
