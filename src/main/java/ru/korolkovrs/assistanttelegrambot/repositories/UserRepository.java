package ru.korolkovrs.assistanttelegrambot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.korolkovrs.assistanttelegrambot.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
