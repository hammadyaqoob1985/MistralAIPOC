package com.hammady.mistral.poc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FunctionResponse {

    private String result;

    public FunctionResponse(String result) {
        this.result = result;
    }

    public FunctionResponse() {
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
