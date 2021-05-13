package ru.korolkovrs.assistanttelegrambot.commands;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.korolkovrs.assistanttelegrambot.services.SendMessageService;

import java.util.Date;

import static ru.korolkovrs.assistanttelegrambot.commands.Commands.*;

public class HelpCommand implements Command {
    final static String MESSAGE = String.format("✨<b>Доступные команды</b>✨\n\n"

                    + "<b>Начать\\закончить работу с ботом</b>\n"
                    + "%s - начать работу со мной\n"
                    + "%s - приостановить работу со мной\n"
                    + "%s [дд мм гггг чч мм] [текст напоминания]  - добавить напоминание\n\n"
                    + "%s - получить помощь в работе со мной\n",
            START.getCommandName(), STOP.getCommandName(), ADD_REMIND.getCommandName(), HELP.getCommandName());
    private SendMessageService sendMessageService;

    public HelpCommand(SendMessageService sendMessageService) {
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
