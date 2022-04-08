package com.wit.restModule.services;

import com.wit.libDataDtoChangelle.consts.RabbitMQConsts;
import com.wit.libDataDtoChangelle.dto.VoteDTO;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteService {
    @Autowired
    private final IRabbitMQService rabbitMQService;

    public VoteService(IRabbitMQService rabbitMQService) {
        this.rabbitMQService = rabbitMQService;
    }

    public void sendMessageComputeVote(VoteDTO dto) {
        dto.setRequestId(MDC.get("requestId"));
        this.rabbitMQService.sendMessage(RabbitMQConsts.QUEUE_VOTE, dto);
    }
}
