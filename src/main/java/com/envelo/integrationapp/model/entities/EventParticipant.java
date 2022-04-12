package com.envelo.integrationapp.model.entities;

import com.envelo.integrationapp.model.enums.Decision;
import com.envelo.integrationapp.model.enums.EventRole;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "event_participants")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class EventParticipant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private AppUser appUser;

    @Enumerated(EnumType.STRING)
    private EventRole eventRole;

    @Enumerated(EnumType.STRING)
    private Decision decision;

    @PrePersist
    public void createdOn() {
        eventRole = EventRole.PARTICIPANT;
        decision = Decision.NOT_DECIDED;
    }
}
