package ru.korolkovrs.assistanttelegrambot.commands;

import com.google.common.collect.ImmutableMap;
import ru.korolkovrs.assistanttelegrambot.services.SendMessageService;

public class CommandContainer {
    private ImmutableMap <String, Command> commandMap;
    private Command unknownCommand;

    public CommandContainer(SendMessageService sendMessageService) {
        commandMap = ImmutableMap.<String, Command>builder()
                .put(Commands.HELP.getCommandName(), new HelpCommand(sendMessageService))
                .put(Commands.START.getCommandName(), new StartCommand(sendMessageService))
                .put(Commands.STOP.getCommandName(), new StopCommand(sendMessageService))
                .put(Commands.NOT.getCommandName(), new NotCommand(sendMessageService))
                .build();
        unknownCommand = new UnknownCommand(sendMessageService);
    }

    public Command getCommand(String commandName) {
        return commandMap.getOrDefault(commandName, unknownCommand);
    }
}
