package ru.korolkovrs.assistanttelegrambot.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reminds")
@Data
public class Remind {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "message")
    private String message;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Remind(String message, Date date, User user) {
        this.message = message;
        this.date = date;
        this.user = user;
    }
}
