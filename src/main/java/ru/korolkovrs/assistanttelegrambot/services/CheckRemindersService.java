package ru.korolkovrs.assistanttelegrambot.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.korolkovrs.assistanttelegrambot.models.User;
import ru.korolkovrs.assistanttelegrambot.repositories.UserRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CheckRemindersService {
    private final UserRepository userRepository;

    public void checkDate(Date currentDate) {
        List<User> users = userRepository.findAll();
        users.stream().forEach(user -> log.info(user.getUsername()));
    }
}
