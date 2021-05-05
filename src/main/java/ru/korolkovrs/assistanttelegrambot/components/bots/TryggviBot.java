package ru.korolkovrs.assistanttelegrambot.components.bots;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


@Component
@Slf4j
public class TryggviBot extends TelegramLongPollingBot {
    @Value("#{environment.bot.username}")
    private String username;

    @Value("#{environment.bot.token}")
    private String token;

    @Override
    public String getBotUsername() {
        log.info(username);
        return username;
    }

    @Override
    public String getBotToken() {
        log.info(token);
        return token;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            String id = update.getMessage().getChatId().toString();

            String answerText = "Tryggvi say: " + messageText.trim();
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(id);
            sendMessage.setText(answerText);

            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
                log.error("Sending error", e);
            }

        }
    }
}
