package ru.korolkovrs.assistanttelegrambot.commands;

import com.google.common.collect.ImmutableMap;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.korolkovrs.assistanttelegrambot.services.SendMessageService;
import ru.korolkovrs.assistanttelegrambot.services.UserService;

@Component
@RequiredArgsConstructor
public class CommandContainer {
    private ImmutableMap <String, Command> commandMap;
    private Command unknownCommand;
    private SendMessageService sendMessageService;
    private final UserService userService;

    @Autowired
    public void setSendMessageService(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
        initCommands();
    }

    private void initCommands() {
        commandMap = ImmutableMap.<String, Command>builder()
                .put(Commands.HELP.getCommandName(), new HelpCommand(sendMessageService))
                .put(Commands.START.getCommandName(), new StartCommand(sendMessageService, userService))
                .put(Commands.STOP.getCommandName(), new StopCommand(sendMessageService))
                .put(Commands.NOT.getCommandName(), new NotCommand(sendMessageService))
                .put(Commands.ADD_REMIND.getCommandName(), new AddReminderCommand(sendMessageService, userService))
                .build();
        unknownCommand = new UnknownCommand(sendMessageService);
    }

    public Command getCommand(String commandName) {
        return commandMap.getOrDefault(commandName, unknownCommand);
    }
}
