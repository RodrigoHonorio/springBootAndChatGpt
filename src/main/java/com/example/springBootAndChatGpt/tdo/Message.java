package com.example.springBootAndChatGpt.tdo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This class represents a message in a chat conversation.
 * A message has two properties: role and content.
 */
@Getter
@Setter
@NoArgsConstructor
public class Message {

    /**
     * The role of the message, indicating the sender or recipient.
     * For example, it could be "user" or "agent".
     */
    private String role;

    /**
     * The content of the message, which contains the actual text.
     * It represents the content of the message exchanged in the chat conversation.
     */
    private String content;

    // Constructors, Getters, and Setters for the Message class

    /**
     * Creates a new instance of Message with the specified role and content.
     *
     * @param role    The role of the message, indicating the sender or recipient.
     * @param content The content of the message, which contains the actual text.
     */
    public Message(String role, String content) {
        this.role = role;
        this.content = content;
    }

    // Getters and setters for the properties of the Message class

    /**
     * Get the role of the message.
     *
     * @return The role of the message.
     */
    public String getRole() {
        return role;
    }

    /**
     * Set the role of the message.
     *
     * @param role The role of the message to be set.
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Get the content of the message.
     *
     * @return The content of the message.
     */
    public String getContent() {
        return content;
    }
}
