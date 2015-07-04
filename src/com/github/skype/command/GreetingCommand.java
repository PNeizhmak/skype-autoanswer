package com.github.skype.command;

import com.skype.ChatMessage;

/**
 * @author Pavel Neyzhmak
 */
public class GreetingCommand implements AbstractCommand {

    private ChatMessage chatMessage;

    public GreetingCommand(ChatMessage message) {
        this.chatMessage = message;
    }

    @Override
    public void execute() throws Exception {
        System.out.println("GreetingCommand");
        chatMessage.getSender().send("I'm working. Please, wait a moment.");
    }
}
