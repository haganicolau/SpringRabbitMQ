package com.wit.restModule.controllers;

import com.wit.libDataDtoChangelle.consts.OperationsConst;
import com.wit.libDataDtoChangelle.dto.OperatorsDTO;
import com.wit.libDataDtoChangelle.dto.ResponseDTO;
import com.wit.restModule.services.OperatorsService;
import com.wit.restModule.validate.ValidateOperators;
import org.springframework.amqp.AmqpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CalculatorController extends AbstractController {

    @Autowired
    private OperatorsService operatorsService;

    @Autowired
    private ValidateOperators validateOperators;

    public CalculatorController(OperatorsService operatorsService) {
        this.operatorsService = operatorsService;
    }

    @RequestMapping(
            value = "/sum",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    public ResponseEntity<String> getSum(
            @RequestParam(name = "a") String a,
            @RequestParam(name = "b") String b
    ) {
        validateOperators.setValues(a, b);
        if (!validateOperators.validateValues()) {
            return getBadRequestMessage("Valores inválidos");
        }

        OperatorsDTO dto = new OperatorsDTO(
                new BigDecimal(a),
                new BigDecimal(b),
                OperationsConst.OPERATION_SUM
        );

        try {
            ResponseDTO response = this.operatorsService.sendMessageOperator(dto);
            return ResponseEntity.ok(response.toJson());
        } catch (AmqpException ex) {
            return getErrorRequestMessage(ex.getMessage());
        }
    }

    @RequestMapping(
            value = "/sub",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    public ResponseEntity<String> getSub(
            @RequestParam(name = "a") String a,
            @RequestParam(name = "b") String b
    ) {
        validateOperators.setValues(a, b);
        if (!validateOperators.validateValues()) {
            return getBadRequestMessage("Valores inválidos");
        }

        OperatorsDTO dto = new OperatorsDTO(
                new BigDecimal(a),
                new BigDecimal(b),
                OperationsConst.OPERATION_SUBTRACTION
        );

        try {
            ResponseDTO response = this.operatorsService.sendMessageOperator(dto);
            return ResponseEntity.ok(response.toJson());
        } catch (AmqpException ex) {
            return getErrorRequestMessage(ex.getMessage());
        }
    }

    @RequestMapping(
            value = "/mult",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    public ResponseEntity<String> getMult(
            @RequestParam(name = "a") String a,
            @RequestParam(name = "b") String b
    ) {
        validateOperators.setValues(a, b);
        if (!validateOperators.validateValues()) {
            return getBadRequestMessage("Valores inválidos");
        }

        OperatorsDTO dto = new OperatorsDTO(
                new BigDecimal(a),
                new BigDecimal(b),
                OperationsConst.OPERATION_MULTIPLICATION
        );

        try {
            ResponseDTO response = this.operatorsService.sendMessageOperator(dto);
            return ResponseEntity.ok(response.toJson());
        } catch (AmqpException ex) {
            return getErrorRequestMessage(ex.getMessage());
        }
    }

    @RequestMapping(
            value = "/div",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    public ResponseEntity<String> getDiv(
            @RequestParam(name = "a") String a,
            @RequestParam(name = "b") String b
    ) {
        validateOperators.setValues(a, b);
        if (!validateOperators.validateValues()) {
            return getBadRequestMessage("Valores inválidos");
        }

        OperatorsDTO dto = new OperatorsDTO(
                new BigDecimal(a),
                new BigDecimal(b),
                OperationsConst.OPERATION_DIVISION
        );

        if (dto.getSecond().compareTo(BigDecimal.ZERO) == 0) {
            return getBadRequestMessage("Impossível dividir número por 0");
        }

        try {
            ResponseDTO response = this.operatorsService.sendMessageOperator(dto);
            return ResponseEntity.ok(response.toJson());
        } catch (AmqpException ex) {
            return getErrorRequestMessage(ex.getMessage());
        }
    }

}
