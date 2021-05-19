package ru.korolkovrs.assistanttelegrambot.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Remind> reminds;

    public User(Long id, String username) {
        this.id = id;
        this.username = username;
        reminds = new ArrayList<>();
    }
}
