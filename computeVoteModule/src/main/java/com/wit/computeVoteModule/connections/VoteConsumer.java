package com.wit.computeVoteModule.connections;

import com.wit.computeVoteModule.services.CandidateService;
import com.wit.computeVoteModule.services.RabbitMQService;
import com.wit.libDataDtoChangelle.consts.RabbitMQConsts;
import com.wit.libDataDtoChangelle.dto.VoteDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VoteConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(VoteConsumer.class);

    @Autowired
    private final CandidateService candidateService;

    public VoteConsumer(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @RabbitListener(queues = RabbitMQConsts.QUEUE_VOTE)
    public void queueConsume(VoteDTO dto) {

        LOGGER.info(dto.toString());
        this.candidateService.addVote(dto.getIdCandidate());

    }
}
