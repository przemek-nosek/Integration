package com.envelo.integrationapp.model.abstracts;

import com.envelo.integrationapp.model.entities.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
abstract public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    private LocalDateTime date;
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.PERSIST)
    private User user;

    public Content(String description, User user) {
        this.description = description;
        this.user = user;
    }

    @PrePersist
    public void createdOn() {
        date = LocalDateTime.now();
    }
}
