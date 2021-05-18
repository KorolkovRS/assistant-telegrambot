package ru.korolkovrs.assistanttelegrambot.commands;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.korolkovrs.assistanttelegrambot.services.SendMessageService;
import ru.korolkovrs.assistanttelegrambot.services.UserService;

public abstract class AbstractCommandTest {
    private SendMessageService sendMessageService;
    private UserService userService;
    private Command command;

    @BeforeEach
    public void init() {
        sendMessageService = Mockito.mock(SendMessageService.class);
        userService = Mockito.mock(UserService.class);
        command = getCommand();
    }

    @Test
    public void shouldProperlyExecuteTest() {
        Long chatId = 724623542342L;

        Message message = Mockito.mock(Message.class);
        Mockito.when(message.getChatId()).thenReturn(chatId);

        Update update = new Update();
        update.setMessage(message);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(getCommandMessage());
        sendMessage.setChatId(chatId.toString());

        command.execute(update);
        Mockito.verify(sendMessageService, Mockito.times(1)).sendMessage(sendMessage);
    }

    public SendMessageService getSendMessageService() {
        return sendMessageService;
    }

    public UserService getUserService() {
        return userService;
    }

    public abstract String getCommandMessage();

    public abstract Command getCommand();
}
