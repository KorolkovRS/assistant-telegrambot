package ru.korolkovrs.assistanttelegrambot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@PropertySource("classpath:secured.yaml")
public class AssistantTelegrambotApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssistantTelegrambotApplication.class, args);
	}
}
