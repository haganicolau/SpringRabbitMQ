package com.wit.engineModule.calculator;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.math.BigDecimal;

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
