package ru.korolkovrs.assistanttelegrambot.commands;

public enum Commands {
    START("/start"),
    STOP("/stop"),
    HELP("/help"),
    UNKNOWN(),
    NOT("/NaC"),
    ADD_REMIND("/add_remind");

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
