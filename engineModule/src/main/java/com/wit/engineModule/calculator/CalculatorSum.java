package com.wit.engineModule.calculator;

import java.math.BigDecimal;

public class CalculatorSum implements Calculator {

    @Override
    public BigDecimal operation(BigDecimal a, BigDecimal b) {
        return a.add(b);
    }
}
