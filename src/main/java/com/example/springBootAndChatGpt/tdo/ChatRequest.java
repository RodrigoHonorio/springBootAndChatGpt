package com.example.springBootAndChatGpt.tdo;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


/**
 * This class represents a request object used to send a chat prompt to the OpenAI API for processing.
 * It contains information such as the model to use, the list of messages, the number of responses
 * expected, and the temperature of the response.
 */
@Getter
@Setter
public class ChatRequest {

    /** The model to use for generating responses. */
    private String model;

    /** The list of messages to be sent as input to the model. */
    private List<Message> messages;

    /** The number of responses to generate for each request. */
    private int n = 1;

    /** The temperature of the response, controlling the randomness of the output. */
    private double temperature;

    /**
     * Creates a new instance of ChatRequest with the specified model and prompt.
     *
     * @param model The model to use for generating responses.
     * @param prompt The chat prompt or message sent by the user.
     */
    public ChatRequest(String model, String prompt) {
        this.model = model;

        // Initialize the list of messages and add the user's prompt as the first message
        this.messages = new ArrayList<>();
        this.messages.add(new Message("user", prompt));
    }

    // Getters and setters for the properties. These methods allow accessing and modifying the
    // properties of the ChatRequest instance.
}
