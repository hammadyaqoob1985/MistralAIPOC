package com.hammady.mistral.poc;

import com.hammady.mistral.poc.dto.FunctionResponse;
import com.hammady.mistral.poc.dto.PromptMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.mistralai.MistralAiChatModel;
import org.springframework.ai.mistralai.MistralAiChatOptions;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/functioncalling")
public class FunctionCallingController {

    private final MistralAiChatModel chatClient;

    public FunctionCallingController(MistralAiChatModel chatClient) {
        this.chatClient = chatClient;
    }
    @CrossOrigin
    @PostMapping("/query")
    public FunctionResponse getPatient(@RequestBody PromptMessage promptMessage) {
        var options = MistralAiChatOptions.builder()
                .function("retrievePatientHealthStatus")
                .build();
        ChatResponse response = chatClient.call(
                new Prompt(promptMessage.getMessage(),  options));

        return new FunctionResponse(response.getResult().getOutput().getContent());
    }
}
