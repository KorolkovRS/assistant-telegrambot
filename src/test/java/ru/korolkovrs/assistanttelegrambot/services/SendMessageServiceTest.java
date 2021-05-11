package ru.korolkovrs.assistanttelegrambot.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.korolkovrs.assistanttelegrambot.components.bots.TryggviBot;

public class SendMessageServiceTest {
    private SendMessageService sendMessageService;
    private TelegramLongPollingBot telegramBot;

    @BeforeEach
    public void init() {
        telegramBot = Mockito.mock(TryggviBot.class);
        sendMessageService = new SendMessageService(telegramBot);
    }

    @Test
    public void shouldProperlySendMessage() throws TelegramApiException {
        String testText = "Test text";
        String chatId = "123456";
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(testText);
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);

        sendMessageService.sendMessage(sendMessage);
        Mockito.verify(telegramBot, Mockito.times(1)).execute(sendMessage);
    }
}
