package ru.korolkovrs.assistanttelegrambot.commands;



import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.korolkovrs.assistanttelegrambot.models.Remind;
import ru.korolkovrs.assistanttelegrambot.models.User;
import ru.korolkovrs.assistanttelegrambot.services.SendMessageService;
import ru.korolkovrs.assistanttelegrambot.services.UserService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static ru.korolkovrs.assistanttelegrambot.commands.Commands.HELP;

@Slf4j
public class AddReminderCommand implements Command {
    static final String DATE_FORMAT = "d-M-yyyy:H-m";
    private SendMessageService sendMessageService;
    private UserService userService;

    public AddReminderCommand(SendMessageService sendMessageService, UserService userService) {
        this.sendMessageService = sendMessageService;
        this.userService = userService;
    }

    @Override
    public void execute(Update update) {
        Message message = update.getMessage();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText("Ваше напоминание установлено.");

        if (userService.existById(update.getMessage().getChatId())) {
            User user = userService.findById(update.getMessage().getChatId());
            try {
                Remind remind = parseMessageToRemind(update.getMessage().getText(), user);
                user.getReminds().add(remind);
                userService.saveOrUpdate(user);
            } catch (ParseException e) {
                sendMessage.setText("Введите дату в формате: " + DATE_FORMAT);
            } catch (IllegalArgumentException e) {
                sendMessage.setText(String.format("Для добавления напоминания введите его в формате: %s [%s] [текст напоминания]",
                        Commands.ADD_REMIND.getCommandName(), AddReminderCommand.DATE_FORMAT));
            }
        } else {
            sendMessage.setText("Для начала работы введите команду " + Commands.START.getCommandName());
        }
        sendMessageService.sendMessage(sendMessage);
    }

    private Remind parseMessageToRemind(String message, User user) throws ParseException, IllegalArgumentException {
        String[] strings = message.split(" ", 3);
        if (strings.length != 3) {
            throw new IllegalArgumentException("Неверный формат сообщения");
        }
        String dateStr = strings[1];
        String remindStr = strings[2];

        DateFormat format = new SimpleDateFormat(DATE_FORMAT, Locale.ENGLISH);
        Date date = format.parse(dateStr);

        System.out.println(dateStr);
        System.out.println(remindStr);
        return new Remind(remindStr, date, user);
    }
}
