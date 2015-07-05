package com.github.skype.command;

import com.skype.ChatMessage;

/**
 * @author Pavel Neyzhmak
 */
public class EmotedCommand extends AbstractCommand {

    public EmotedCommand(ChatMessage message) {
        super(message);
    }

    @Override
    public void execute() throws Exception {
        System.out.println("EmotedCommand");
        chatMessage.getSender().send(":)");
    }
}
