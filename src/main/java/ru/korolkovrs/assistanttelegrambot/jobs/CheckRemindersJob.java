package ru.korolkovrs.assistanttelegrambot.jobs;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.korolkovrs.assistanttelegrambot.services.CheckRemindersService;

import java.util.Date;

@Component
@Slf4j
@RequiredArgsConstructor
public class CheckRemindersJob {
    private final CheckRemindersService checkRemindersService;

    @Scheduled(fixedDelay = 45_000)
    public void checkReminders() {
        Date currentDate = new Date();
        checkRemindersService.checkDate(currentDate);
    }
}
