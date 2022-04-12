package com.envelo.integrationapp.model.entities;

import com.envelo.integrationapp.model.enums.Decision;
import com.envelo.integrationapp.model.enums.EventRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "event_participants")
@NoArgsConstructor
@Getter
@Setter
public class EventParticipant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private AppUser appUser;

    @Enumerated(EnumType.STRING)
    private EventRole eventRole;

    @Enumerated(EnumType.STRING)
    private Decision decision;
}
