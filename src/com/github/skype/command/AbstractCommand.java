package com.github.skype.command;

import com.skype.ChatMessage;

/**
 * @author Pavel Neyzhmak
 */
public abstract class AbstractCommand {

    protected ChatMessage chatMessage;

    public abstract void execute() throws Exception;

    public AbstractCommand(ChatMessage message) {
        this.chatMessage = message;
    }
}
