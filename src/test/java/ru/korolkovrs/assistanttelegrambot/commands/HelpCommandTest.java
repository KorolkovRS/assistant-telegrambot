package ru.korolkovrs.assistanttelegrambot.commands;

class HelpCommandTest extends AbstractCommandTest{

    @Override
    public String getCommandMessage() {
        return HelpCommand.MESSAGE;
    }

    @Override
    public Command getCommand() {
        return new HelpCommand(super.getSendMessageService());
    }
}