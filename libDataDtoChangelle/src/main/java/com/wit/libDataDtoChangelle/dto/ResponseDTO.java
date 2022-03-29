package com.wit.libDataDtoChangelle.dto;

public class ResponseDTO extends AbstractDataDTO {

    private String result;

    public ResponseDTO(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public String toJson() {
        return "{\"result\" :\"" + result + "\"}";
    }

    @Override
    public String toString() {
        return "ResponseDTO {" +
                "result='" + result + '\'' +
                '}';
    }
}
