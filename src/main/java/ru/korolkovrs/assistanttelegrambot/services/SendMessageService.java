package ru.korolkovrs.assistanttelegrambot.services;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class SendMessageService {
    private TelegramLongPollingBot telegramBot;

    public SendMessageService(TelegramLongPollingBot telegramBot) {
        this.telegramBot = telegramBot;
    }

    public void sendMessage(SendMessage sendMessage) {

        try {
            telegramBot.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
