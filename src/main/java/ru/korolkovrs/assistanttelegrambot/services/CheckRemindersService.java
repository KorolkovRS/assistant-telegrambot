package ru.korolkovrs.assistanttelegrambot.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import ru.korolkovrs.assistanttelegrambot.models.Remind;
import ru.korolkovrs.assistanttelegrambot.models.User;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CheckRemindersService {
    private final RemindService remindService;
    private final UserService userService;
    private final SendMessageService sendMessageService;
    private static final Long DELAY = 40_000L;

    public void checkDate(Date currentDate) {
        List<Remind> reminds = remindService.findAll();
        reminds.stream().forEach(remind -> {
            Long currentDelay = currentDate.getTime() - remind.getDate().getTime();
            if (currentDelay >= 0 && currentDelay <= DELAY) {
                collectSendMessage(remind, userService.findById(remind.getUser().getId()));
            }
        });
    }

    public void collectSendMessage(Remind remind, User user) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(remind.getMessage());
        sendMessage.setChatId(user.getId().toString());
        sendMessageService.sendMessage(sendMessage);
    }
}
