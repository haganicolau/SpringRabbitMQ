package com.wit.libDataDtoChangelle.dto;

import java.math.BigDecimal;

public class OperatorsDTO extends AbstractDataDTO {

    private BigDecimal first;
    private BigDecimal second;
    private String operationType;

    public OperatorsDTO(BigDecimal first, BigDecimal second, String operationType) {
        super();
        this.first = first;
        this.second = second;
        this.operationType = operationType;
    }

    public BigDecimal getFirst() {
        return first;
    }

    public void setFirst(BigDecimal first) {
        this.first = first;
    }

    public BigDecimal getSecond() {
        return second;
    }

    public void setSecond(BigDecimal second) {
        this.second = second;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    @Override
    public String toString() {
        return "OperatorsDTO {" +
                "requestId= " + super.requestId +
                ", first=" + first +
                ", second=" + second +
                ", operationType='" + operationType + '\'' +
                '}';
    }
}
