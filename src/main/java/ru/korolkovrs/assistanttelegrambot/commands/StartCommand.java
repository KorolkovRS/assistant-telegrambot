package ru.korolkovrs.assistanttelegrambot.commands;

import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.korolkovrs.assistanttelegrambot.models.User;
import ru.korolkovrs.assistanttelegrambot.services.SendMessageService;
import ru.korolkovrs.assistanttelegrambot.services.UserService;

@Slf4j
public class StartCommand implements Command {
    final static String MESSAGE = "Меня зовут Трюгви. Что-бы узнать, что я умею напиши /help.";
    private SendMessageService sendMessageService;
    private UserService userService;

    public StartCommand(SendMessageService sendMessageService, UserService userService) {
        this.sendMessageService = sendMessageService;
        this.userService = userService;
    }

    @Override
    public void execute(Update update) {
        User user = new User(update.getMessage().getChatId(), update.getMessage().getFrom().getFirstName());
        log.info(user.getUsername());
        log.info(user.getId().toString());
        userService.saveOrUpdate(user);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId().toString());
        sendMessage.setText(String.format("Привет, %s! %s", user.getUsername(), MESSAGE));
        sendMessageService.sendMessage(sendMessage);
    }
}
