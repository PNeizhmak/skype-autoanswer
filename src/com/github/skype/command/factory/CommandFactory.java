package com.github.skype.command.factory;

import com.github.skype.command.AbstractCommand;
import com.github.skype.command.EmotedCommand;
import com.github.skype.command.GreetingCommand;
import com.github.skype.command.InterrogativeCommand;
import com.skype.ChatMessage;

/**
 * @author Pavel Neyzhmak
 */
public class CommandFactory {

    public static AbstractCommand getCommand(final String requestedCommand, final ChatMessage message) {

        CommandType command;
        try {
            command = CommandType.valueOf(requestedCommand.toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException(ex);
        }

        switch (command) {
            case GREETING:
                return new GreetingCommand(message);
            case EMOTED:
                return new EmotedCommand(message);
            case INTERROGATIVE:
                return new InterrogativeCommand(message);

            default:
                //todo: think about this
                return new GreetingCommand(message);
        }
    }
}
