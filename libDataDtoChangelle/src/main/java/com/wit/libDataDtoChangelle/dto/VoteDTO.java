package com.wit.libDataDtoChangelle.dto;

import java.math.BigDecimal;

public class VoteDTO extends AbstractDataDTO {

    private BigDecimal idCandidate;

    public VoteDTO(BigDecimal id) {
        this.idCandidate = id;
    }

    @Override
    public String toString() {
        return "VoteDTO {" +
                "idCandidate='" + idCandidate + '\'' +
                '}';
    }
}
