package com.envelo.integrationapp.model.entities;


import com.envelo.integrationapp.model.enums.EventStatus;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "events_entity")
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)//, optional = false)
    private EventPlace eventPlace;

    @OneToMany
    @JoinColumn(name = "event_id")
    private List<Post> eventPosts = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "event_id")
    private List<Feedback> feedbacks = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private EventStatus eventStatus;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "event_id")
    private List<EventParticipant> participants = new ArrayList<>();
}
