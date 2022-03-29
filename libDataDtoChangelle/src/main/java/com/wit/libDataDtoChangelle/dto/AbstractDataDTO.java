package com.wit.libDataDtoChangelle.dto;

import java.io.Serializable;

public abstract class AbstractDataDTO implements Serializable {
    protected static final long serialVersionUID = 1L;
    protected String requestId;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
