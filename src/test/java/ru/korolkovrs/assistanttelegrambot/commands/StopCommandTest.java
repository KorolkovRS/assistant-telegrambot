package ru.korolkovrs.assistanttelegrambot.commands;

public class StopCommandTest extends AbstractCommandTest {
    @Override
    public String getCommandMessage() {
        return StopCommand.MESSAGE;
    }

    @Override
    public Command getCommand() {
        return new StopCommand(getSendMessageService());
    }
}
