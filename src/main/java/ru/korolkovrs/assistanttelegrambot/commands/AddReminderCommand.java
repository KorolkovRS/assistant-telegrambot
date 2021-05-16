package ru.korolkovrs.assistanttelegrambot.commands;



import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.korolkovrs.assistanttelegrambot.services.SendMessageService;

@Slf4j
public class AddReminderCommand implements Command {
    static final String MESSAGE = "";
    private SendMessageService sendMessageService;

    public AddReminderCommand(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(Update update) {
        Message message = update.getMessage();

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText(message.getFrom().getFirstName());
        sendMessageService.sendMessage(sendMessage);
    }
}
