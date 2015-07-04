package com.github.skype.command;

import com.skype.ChatMessage;

/**
 * @author Pavel Neyzhmak
 */
public class EmotedCommand implements AbstractCommand {

    private ChatMessage chatMessage;

    public EmotedCommand(ChatMessage message) {
        this.chatMessage = message;
    }

    @Override
    public void execute() throws Exception {
        System.out.println("EmotedCommand");
        chatMessage.getSender().send(":)");
    }
}
