package ru.korolkovrs.assistanttelegrambot.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.korolkovrs.assistanttelegrambot.models.Remind;
import ru.korolkovrs.assistanttelegrambot.repositories.RemindRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RemindService {
    private final RemindRepository remindRepository;

    public List<Remind> findAll() {
        return remindRepository.findAll();
    }
}
