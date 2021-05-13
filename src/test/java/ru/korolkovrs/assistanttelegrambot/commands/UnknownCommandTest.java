package ru.korolkovrs.assistanttelegrambot.commands;

public class UnknownCommandTest extends AbstractCommandTest {
    @Override
    public String getCommandMessage() {
        return UnknownCommand.MESSAGE;
    }

    @Override
    public Command getCommand() {
        return new UnknownCommand(getSendMessageService());
    }
}
