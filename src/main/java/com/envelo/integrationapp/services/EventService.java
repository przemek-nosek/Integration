package com.envelo.integrationapp.services;

import com.envelo.integrationapp.model.dtos.EventCreationDto;
import com.envelo.integrationapp.model.entities.Event;
import com.envelo.integrationapp.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EventService {

    private final EventRepository eventRepository;


    public Event addEvent(EventCreationDto eventCreationDto) {
        Event event = Event.builder()
                .title(eventCreationDto.getTitle())
                .description(eventCreationDto.getDescription())
                .minMembers(eventCreationDto.getMinMembers())
                .maxMembers(eventCreationDto.getMaxMembers())
                .startDate(eventCreationDto.getStartDate())
                .endDate(eventCreationDto.getEndDate())
                .deadlineDecision(eventCreationDto.getDeadlineDecision())
                .eventPlace(eventCreationDto.getEventPlace())
                .participants(eventCreationDto.getParticipants())
                .build();


        return eventRepository.save(event);
    }
}
