package com.wit.engineModule.calculator;

import java.math.BigDecimal;

public class CalculatorSub implements Calculator {

    @Override
    public BigDecimal operation(BigDecimal a, BigDecimal b) {
        return a.subtract(b);
    }
}
