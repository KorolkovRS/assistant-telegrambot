package ru.korolkovrs.assistanttelegrambot.commands;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.korolkovrs.assistanttelegrambot.services.SendMessageService;

import java.util.Arrays;

class CommandContainerTest {
    private CommandContainer commandContainer;

    @BeforeEach
    public void init() {
        commandContainer = new CommandContainer(Mockito.mock(SendMessageService.class));
    }

    @Test
    public void shouldProperlyValidCommand() {
        Arrays.stream(Commands.values()).forEach(commands -> {
            if (commands.getCommandName() != null) {
                Command command = commandContainer.getCommand(commands.getCommandName());
                Assert.assertNotEquals(command.getClass(), UnknownCommand.class);
            }
        });
    }

    @Test
    public void shouldProperlyUnknownCommand() {
        Arrays.stream(Commands.values()).forEach(commands -> {
            String commandName = "dfdjhfdhf";
            Command command = commandContainer.getCommand(commandName);
            Assert.assertEquals(command.getClass(), UnknownCommand.class);
        });
    }
}