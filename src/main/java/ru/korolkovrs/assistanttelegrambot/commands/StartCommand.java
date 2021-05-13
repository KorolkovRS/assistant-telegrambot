package ru.korolkovrs.assistanttelegrambot.commands;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.korolkovrs.assistanttelegrambot.services.SendMessageService;

public class StartCommand implements Command {
    final static String MESSAGE = "Привет! Меня зовут Трюгви. Что-бы узнать, что я умею напиши /help.";
    private SendMessageService sendMessageService;

    public StartCommand(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId().toString());
        sendMessage.setText(MESSAGE);
        sendMessageService.sendMessage(sendMessage);
    }
}
