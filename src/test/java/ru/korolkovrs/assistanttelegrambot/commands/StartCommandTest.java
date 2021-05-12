package ru.korolkovrs.assistanttelegrambot.commands;

public class StartCommandTest extends AbstractCommandTest {
    @Override
    public String getCommandMessage() {
        return StartCommand.MESSAGE;
    }

    @Override
    public Command getCommand() {
        return new StartCommand(getSendMessageService());
    }
}
