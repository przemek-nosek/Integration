package com.envelo.integrationapp.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    private int minMembers;
    private int maxMembers;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private LocalDateTime deadlineDecision;
    @ManyToOne
    private User eventCreator;
    @ManyToMany
    private List<User> guests;
    @ManyToOne
    private EventPlace eventPlace;
    @OneToMany
    private List<Post> posts;
    @OneToMany
    private List<Feedback> feedbacks;
    @Enumerated(value = EnumType.STRING)
    private EventStatus eventStatus;
}
