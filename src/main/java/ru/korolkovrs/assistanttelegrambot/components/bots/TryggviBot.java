package ru.korolkovrs.assistanttelegrambot.components.bots;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.korolkovrs.assistanttelegrambot.commands.CommandContainer;
import ru.korolkovrs.assistanttelegrambot.commands.Commands;
import ru.korolkovrs.assistanttelegrambot.services.RemindService;
import ru.korolkovrs.assistanttelegrambot.services.SendMessageService;
import ru.korolkovrs.assistanttelegrambot.services.UserService;

import javax.annotation.PostConstruct;


@Component
@Slf4j
@RequiredArgsConstructor
public class TryggviBot extends TelegramLongPollingBot {
    private CommandContainer commandContainer;
    private SendMessageService sendMessageService;
    private final UserService userService;
    private final RemindService remindService;

    private static String COMMAND_PREFIX = "/";

    @Value("${username}")
    private String username;

    @Value("${token}")
    private String token;

    @Autowired
    public void setCommandContainer(CommandContainer commandContainer) {
        this.commandContainer = commandContainer;
    }

    @Autowired
    public void setSendMessageService(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }

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

            if (messageText.startsWith(COMMAND_PREFIX)) {
                String commandName = messageText.split(" ")[0].toLowerCase();
                commandContainer.getCommand(commandName).execute(update);
            } else {
                commandContainer.getCommand(Commands.NOT.getCommandName()).execute(update);
            }
        }
    }
}
