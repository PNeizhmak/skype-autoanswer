package com.github.skype.command;

import com.skype.ChatMessage;

/**
 * @author Pavel Neyzhmak
 */
public class EmotionCommand extends AbstractCommand {

    public EmotionCommand(ChatMessage message) {
        super(message);
    }

    @Override
    public void execute() throws Exception {
        System.out.println("EmotionCommand");
        chatMessage.getSender().send("я вижу ты любишь смайлики )");
    }
}
