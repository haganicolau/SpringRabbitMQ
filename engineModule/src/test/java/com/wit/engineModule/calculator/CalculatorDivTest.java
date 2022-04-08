package com.wit.engineModule.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class CalculatorDivTest {

    @Test
    public void operationTestSuccess() {
        BigDecimal num1 = new BigDecimal(10);
        BigDecimal num2 = new BigDecimal(2);
        CalculatorDiv calDiv = new CalculatorDiv();
        BigDecimal response = calDiv.operation(num1, num2);

        assertEquals(new BigDecimal(5), response);
    }

    @Test
    public void operationTestFail() {
        BigDecimal num1 = new BigDecimal(10);
        BigDecimal num2 = new BigDecimal(2);
        CalculatorDiv calDiv = new CalculatorDiv();
        BigDecimal response = calDiv.operation(num1, num2);

        assertNotEquals(new BigDecimal(4), response);
    }
}
