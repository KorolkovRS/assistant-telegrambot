package ru.korolkovrs.assistanttelegrambot.commands;

public class NotCommandTest extends AbstractCommandTest {
    @Override
    public String getCommandMessage() {
        return NotCommand.MESSAGE;
    }

    @Override
    public Command getCommand() {
        return new NotCommand(getSendMessageService());
    }
}
