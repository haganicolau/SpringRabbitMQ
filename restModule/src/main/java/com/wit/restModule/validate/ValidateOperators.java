package com.wit.restModule.validate;

import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class ValidateOperators implements Validate{

    private String numberA;
    private String numberB;
    private Pattern pattern;

    public void setValues(String a, String b) {
        this.numberA = a;
        this.numberB = b;
    }

    public boolean validateValues() {
        if (numberA.isEmpty() || numberB.isEmpty()) {
            return false;
        }

        return isNumeric(numberA) && isNumeric(numberB);
    }

    public boolean isNumeric(String strNum) {
        this.pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        return pattern.matcher(strNum).matches();
    }

}
