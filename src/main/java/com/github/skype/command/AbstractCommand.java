package com.github.skype.command;

import com.skype.ChatMessage;

/**
 * @author Pavel Neyzhmak
 */
public abstract class AbstractCommand {

    protected ChatMessage chatMessage;

    protected String incomingText;

    public AbstractCommand(ChatMessage message) {
        this.chatMessage = message;
    }

    public AbstractCommand(ChatMessage message, String incomingText) {
        this.chatMessage = message;
        this.incomingText = incomingText;
    }

    public abstract void execute() throws Exception;
}
