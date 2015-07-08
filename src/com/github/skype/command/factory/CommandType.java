package com.github.skype.command.factory;

/**
 * @author Pavel Neyzhmak
 */
public enum CommandType {

    EMOTION("emotion"),
    GREETING("greeting"),
    INTERROGATIVE("interrogative"),
    DIRTY("dirty");

    private final String command;

    private CommandType(final String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
