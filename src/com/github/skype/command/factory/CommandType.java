package com.github.skype.command.factory;

/**
 * @author Pavel Neyzhmak
 */
public enum CommandType {

    EMOTED("emoted"),
    GREETING("greeting");

    private final String command;

    private CommandType(final String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
