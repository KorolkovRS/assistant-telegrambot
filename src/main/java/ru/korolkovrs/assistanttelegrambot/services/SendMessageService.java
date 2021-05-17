package ru.korolkovrs.assistanttelegrambot.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
@Slf4j
public class SendMessageService {
    private TelegramLongPollingBot telegramBot;

    public SendMessageService(TelegramLongPollingBot telegramBot) {
        this.telegramBot = telegramBot;
    }

    public void sendMessage(SendMessage sendMessage) {
        log.info(sendMessage.getChatId());
        log.info(sendMessage.getText());
        try {
            telegramBot.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
