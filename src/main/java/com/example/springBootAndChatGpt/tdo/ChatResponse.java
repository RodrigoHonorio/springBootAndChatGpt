package com.example.springBootAndChatGpt.tdo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * This class represents the response received from the OpenAI API after processing a chat prompt.
 * It contains a list of choices, where each choice consists of an index and a message object.
 */
@Getter
@Setter
@NoArgsConstructor
public class ChatResponse {

    /** The list of choices containing the generated responses and their corresponding indices. */
    private List<Choice> choices;

    /**
     * This class represents a choice in the chat response, consisting of an index and a message object.
     * Each choice contains information about a generated response.
     */
    @Getter
    @Setter
    @NoArgsConstructor
    public static class Choice {

        /** The index of the choice, indicating its position in the list of responses. */
        private int index;

        /** The message object representing the generated response. */
        private Message message;

        // Constructors, Getters, and Setters for the Choice class

        /**
         * Creates a new instance of Choice with the specified index and message.
         *
         * @param index   The index of the choice.
         * @param message The message object representing the generated response.
         */
        public Choice(int index, Message message) {
            this.index = index;
            this.message = message;
        }

        // Getters and setters for the properties of the Choice class
    }

    // Constructors, Getters, and Setters for the ChatResponse class

    /**
     * Creates a new instance of ChatResponse with the specified list of choices.
     *
     * @param choices The list of choices containing the generated responses and their corresponding indices.
     */
    public ChatResponse(List<Choice> choices) {
        this.choices = choices;
    }

    // Getters and setters for the properties of the ChatResponse class
}
