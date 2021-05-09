package ru.korolkovrs.assistanttelegrambot.commands;

public enum Commands {
    START("/start"),
    STOP("/stop"),
    HELP("/help"),
    UNKNOWN,
    NOT("/NaC");

    private String commandName;

    Commands() {
    }

    Commands(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }
}
