package com.envelo.integrationapp.model.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

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
    private EventPlace eventPlace;

    private Map<Boolean, List<User>> hosts;
    private Map<Decision, List<User>> guests;
    @OneToMany
    private List<Post> posts;
    private List<Feedback> feedbacks;
    @Enumerated(value = EnumType.STRING)
    private EventStatus eventStatus;
}
