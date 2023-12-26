package com.example.CreditCardFraudDetectionBE.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseObject {
    @JsonProperty
    private String status;
    @JsonProperty
    private String message;
    @JsonProperty
    private Object data;

    public ResponseObject() {
    }

    public ResponseObject(String status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}