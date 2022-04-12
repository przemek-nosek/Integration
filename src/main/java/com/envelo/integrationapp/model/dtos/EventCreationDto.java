package com.envelo.integrationapp.model.dtos;

import com.envelo.integrationapp.model.entities.EventParticipant;
import com.envelo.integrationapp.model.entities.EventPlace;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EventCreationDto {
    private String title;
    private String description;
    private int minMembers;
    private int maxMembers;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private LocalDateTime deadlineDecision;
    private EventPlace eventPlace;
    private List<EventParticipantDto> participants = new ArrayList<>();
}
