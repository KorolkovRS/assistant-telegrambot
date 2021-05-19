package ru.korolkovrs.assistanttelegrambot.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.korolkovrs.assistanttelegrambot.models.User;
import ru.korolkovrs.assistanttelegrambot.repositories.UserRepository;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User saveOrUpdate(User user) {
        return userRepository.save(user);
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Неизвестная ошибка при обработке User"));
    }

    public boolean existById(Long id) {
        return userRepository.existsById(id);
    }
}
