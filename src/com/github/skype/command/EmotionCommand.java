package com.github.skype.command;

import com.skype.ChatMessage;

/**
 * @author Pavel Neyzhmak
 */
public class EmotionCommand extends AbstractCommand {

    public EmotionCommand(ChatMessage message, String incomingText) {
        super(message, incomingText);
    }

    @Override
    public void execute() throws Exception {
        System.out.println("EmotionCommand");
        //todo: vary 1st part
        chatMessage.getSender().send("и я " + incomingText);
    }
}
