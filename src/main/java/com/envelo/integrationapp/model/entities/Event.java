package com.envelo.integrationapp.model.entities;


import com.envelo.integrationapp.model.enums.EventStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "events_entity")
@NoArgsConstructor
@Getter
@Setter
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private int minMembers;
    private int maxMembers;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private LocalDateTime deadlineDecision;

    @OneToOne
    private EventPlace eventPlace;

    @OneToMany
    @JoinColumn(name = "event_id")
    private List<Post> eventPosts = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "event_id")
    private List<Feedback> feedbacks = new ArrayList<>();

    @Enumerated(EnumType.ORDINAL)
    private EventStatus eventStatus;

    @OneToMany(mappedBy = "event")
    private List<EventParticipant> participants = new ArrayList<>();
}
