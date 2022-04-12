package com.wit.engineModule.calculator;

import com.wit.libDataDtoChangelle.consts.OperationsConst;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class FactoryCalculatorTest {

    @Test
    public void operationFactoryGetSumClass() {
        FactoryCalculator factoryCalculator = new FactoryCalculator();
        Calculator cal = factoryCalculator.getOperation(OperationsConst.OPERATION_SUM);

        assertEquals(cal.getClass(), CalculatorSum.class);
    }

    @Test
    public void operationFactoryGetSubClass() {
        FactoryCalculator factoryCalculator = new FactoryCalculator();
        Calculator cal = factoryCalculator.getOperation(OperationsConst.OPERATION_SUBTRACTION);

        assertEquals(cal.getClass(), CalculatorSub.class);
    }

    @Test
    public void operationFactoryGetDivClass() {
        FactoryCalculator factoryCalculator = new FactoryCalculator();
        Calculator cal = factoryCalculator.getOperation(OperationsConst.OPERATION_DIVISION);

        assertEquals(cal.getClass(), CalculatorDiv.class);
    }

    @Test
    public void operationFactoryGetMultiClass() {
        FactoryCalculator factoryCalculator = new FactoryCalculator();
        Calculator cal = factoryCalculator.getOperation(OperationsConst.OPERATION_MULTIPLICATION);

        assertEquals(cal.getClass(), CalculatorMult.class);
    }
}
