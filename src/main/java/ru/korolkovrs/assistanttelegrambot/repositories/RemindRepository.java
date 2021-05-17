package ru.korolkovrs.assistanttelegrambot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.korolkovrs.assistanttelegrambot.models.Remind;

public interface RemindRepository extends JpaRepository<Remind, Long> {
}
