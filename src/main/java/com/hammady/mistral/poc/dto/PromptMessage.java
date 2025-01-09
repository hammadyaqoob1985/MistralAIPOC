package com.hammady.mistral.poc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PromptMessage {

    @JsonProperty("prompt_message")
    private String message;

    public PromptMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
