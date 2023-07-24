package com.example.springBootAndChatGpt.controller;

import com.example.springBootAndChatGpt.tdo.ChatRequest;
import com.example.springBootAndChatGpt.tdo.ChatResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * This class represents a REST controller that handles chat-related requests.
 * It exposes an endpoint "/chat" to interact with the OpenAI API and get chat responses.
 */
@RestController
@RequestMapping("chat")
public class ChatController {

    @Qualifier("openaiRestTemplate")
    @Autowired
    private RestTemplate restTemplate;

    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String apiUrl;

    /**
     * Handles the chat request and returns the response from the OpenAI API.
     *
     * @param prompt The chat prompt provided by the client.
     * @return The response generated by the OpenAI API as a string.
     */
    @GetMapping
    public String chat(@RequestBody String prompt) {

        // Create a request object to send to the OpenAI API
        ChatRequest request = new ChatRequest(model, prompt);

        // Call the OpenAI API using the configured RestTemplate to get the response
        ChatResponse response = restTemplate.postForObject(apiUrl, request, ChatResponse.class);

        // Check if the response or the choices are empty
        if (response == null || response.getChoices() == null || response.getChoices().isEmpty()) {
            return "No response";
        }

        // Return the first chat response generated by the OpenAI API
        return response.getChoices().get(0).getMessage().getContent();
    }
}