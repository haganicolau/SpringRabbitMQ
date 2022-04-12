package com.wit.restModule.controllers;

import com.wit.libDataDtoChangelle.dto.ResponseDTO;
import com.wit.libDataDtoChangelle.dto.VoteDTO;
import com.wit.restModule.services.VoteService;
import org.springframework.amqp.AmqpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VoteController extends AbstractController {

    @Autowired
    private VoteService voteService;

    @RequestMapping(
            value = "/vote",
            method = RequestMethod.POST,
            produces = "application/json"
    )
    public ResponseEntity<String> postVote(@RequestBody VoteDTO dto) {

        try {
            this.voteService.sendMessageComputeVote(dto);
            return ResponseEntity.ok(new ResponseDTO("success").toString());
        } catch (AmqpException ex) {
            return getErrorRequestMessage(ex.getMessage());
        }
    }

}
