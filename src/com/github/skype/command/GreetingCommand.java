package com.github.skype.command;

import com.skype.ChatMessage;

/**
 * @author Pavel Neyzhmak
 */
public class GreetingCommand extends AbstractCommand {

    public GreetingCommand(ChatMessage message) {
        super(message);
    }

    @Override
    public void execute() throws Exception {
        System.out.println("GreetingCommand");
        chatMessage.getSender().send("I'm working. Please, wait a moment.");
    }
}
