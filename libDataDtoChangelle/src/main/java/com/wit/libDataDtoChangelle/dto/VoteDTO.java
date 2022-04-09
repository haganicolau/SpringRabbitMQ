package com.wit.libDataDtoChangelle.dto;

import java.math.BigDecimal;

public class VoteDTO extends AbstractDataDTO {

    private String idCandidate;

    public VoteDTO() {}

    public String getIdCandidate() {
        return idCandidate;
    }

    public void setIdCandidate(String idCandidate) {
        this.idCandidate = idCandidate;
    }

    @Override
    public String toString() {
        return "VoteDTO {" +
                "idCandidate='" + idCandidate + '\'' +
                '}';
    }
}
