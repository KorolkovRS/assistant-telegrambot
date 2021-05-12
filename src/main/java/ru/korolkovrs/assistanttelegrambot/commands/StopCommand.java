package ru.korolkovrs.assistanttelegrambot.commands;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.korolkovrs.assistanttelegrambot.services.SendMessageService;

public class StopCommand implements Command {
    final static String MESSAGE = "Пока-пока!";
    private SendMessageService sendMessageService;

    public StopCommand(SendMessageService sendMessageService) {
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
