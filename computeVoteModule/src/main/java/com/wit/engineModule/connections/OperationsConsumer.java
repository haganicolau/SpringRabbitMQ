package com.wit.engineModule.connections;

import com.wit.engineModule.calculator.FactoryCalculator;
import com.wit.engineModule.services.RabbitMQService;
import com.wit.libDataDtoChangelle.consts.RabbitMQConsts;
import com.wit.libDataDtoChangelle.dto.OperatorsDTO;
import com.wit.libDataDtoChangelle.dto.ResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class OperationsConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(OperationsConsumer.class);

    @Autowired
    private final RabbitMQService rabbitMQService;

    @Autowired
    private final FactoryCalculator factoryCalculator;

    public OperationsConsumer(RabbitMQService service, FactoryCalculator factoryCalculator) {
        this.rabbitMQService = service;
        this.factoryCalculator = factoryCalculator;
    }

    @RabbitListener(queues = RabbitMQConsts.QUEUE_CALCULATE)
    public void queueConsume(OperatorsDTO dto) {

        LOGGER.info(dto.toString());

        BigDecimal result = this.factoryCalculator
                .getOperation(dto.getOperationType())
                .operation(dto.getFirst(), dto.getSecond());

        ResponseDTO response = new ResponseDTO(result.toString());
        response.setRequestId(dto.getRequestId());
        this.rabbitMQService.sendMessage(RabbitMQConsts.QUEUE_RESPONSE, response);
    }
}
