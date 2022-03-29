package com.wit.engineModule.calculator;

import com.wit.libDataDtoChangelle.consts.OperationsConst;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class FactoryCalculator {

    private final Map<String, Calculator> operations;

    public FactoryCalculator() {
        operations = new HashMap<>();
        operations.put(OperationsConst.OPERATION_SUM, new CalculatorSum());
        operations.put(OperationsConst.OPERATION_DIVISION, new CalculatorDiv());
        operations.put(OperationsConst.OPERATION_MULTIPLICATION, new CalculatorMult());
        operations.put(OperationsConst.OPERATION_SUBTRACTION, new CalculatorSub());
    }

    public Calculator getOperation(String calculatorType) {
        return this.operations.get(calculatorType);
    }
}
