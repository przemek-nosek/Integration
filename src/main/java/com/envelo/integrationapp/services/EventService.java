package com.envelo.integrationapp.services;

import com.envelo.integrationapp.model.dtos.EventCreationDto;
import com.envelo.integrationapp.model.dtos.info.EventDtoInfo;

import com.envelo.integrationapp.model.dtos.info.EventParticipantDtoInfo;
import com.envelo.integrationapp.model.dtos.info.EventPlaceDtoInfo;
import com.envelo.integrationapp.model.entities.Event;
import com.envelo.integrationapp.model.entities.EventParticipant;
import com.envelo.integrationapp.model.enums.EventRole;

import com.envelo.integrationapp.model.entities.Event;
import com.envelo.integrationapp.model.entities.EventParticipant;
import com.envelo.integrationapp.model.enums.EventStatus;
import com.envelo.integrationapp.model.dtos.EventParticipantDto;

import com.envelo.integrationapp.repositories.EventRepository;
import com.envelo.integrationapp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EventService {

    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    public void addEvent(EventCreationDto eventCreationDto) {
        List<EventParticipant> eventParticipants = mapParticipants(eventCreationDto);

        Event event = Event.builder()
                .title(eventCreationDto.getTitle())
                .description(eventCreationDto.getDescription())
                .minMembers(eventCreationDto.getMinMembers())
                .maxMembers(eventCreationDto.getMaxMembers())
                .startDate(eventCreationDto.getStartDate())
                .endDate(eventCreationDto.getEndDate())
                .deadlineDecision(eventCreationDto.getDeadlineDecision())
                .eventPlace(eventCreationDto.getEventPlace())
                .participants(eventParticipants)
                .build();

        Event save = eventRepository.save(event);
        log.info("SAVEDDDDDDDDDD");
    }

    public Set<EventDtoInfo> getEventByUserStatus(long userId, EventStatus eventStatus) {
        List<Event> listEventsByStatus = eventRepository.findAllByEventStatus(eventStatus);
        Set<EventDtoInfo> returnListEvent = new HashSet<>();
        for (Event event : listEventsByStatus) {
            for (EventParticipant participant : event.getParticipants()) {
                if (participant.getId() == userId) {
                    EventDtoInfo eventDtoInfo = new EventDtoInfo();
                    eventDtoInfo.setId(event.getId());
                    eventDtoInfo.setTitle(event.getTitle());
                    eventDtoInfo.setStartDate(event.getStartDate());
                    eventDtoInfo.setEndDate(event.getEndDate());
                    returnListEvent.add(eventDtoInfo);
                }
            }
        }
        return returnListEvent;
    }

    public List<EventDtoInfo> getAllUserCreatedEvents(Long userId, EventRole eventRole) {
        List<Event> events = eventRepository.findEventsByCreator(userId, eventRole);
        List<EventDtoInfo> eventDtos = new ArrayList<>();
        for (Event event : events) {
            for (EventParticipant participant : event.getParticipants()) {
                if (participant.getId() == userId) {
                    EventDtoInfo eventDtoInfo = new EventDtoInfo();
                    eventDtoInfo.setId(event.getId());
                    eventDtoInfo.setTitle(event.getTitle());
                    eventDtoInfo.setStartDate(event.getStartDate());
                    eventDtoInfo.setEndDate(event.getEndDate());
                    eventDtoInfo.setEventStatus(event.getEventStatus());
                    eventDtos.add(eventDtoInfo);
                }
            }
        }
        return eventDtos;
    }

    @Transactional
    public void updateEvent(Long id, EventCreationDto eventCreationDto) {
        List<EventParticipant> eventParticipants = mapParticipants(eventCreationDto);

        Event byId = eventRepository.getById(id);
        byId.setTitle(eventCreationDto.getTitle());
        byId.setDescription(eventCreationDto.getDescription());
        byId.setMinMembers(eventCreationDto.getMinMembers());
        byId.setMaxMembers(eventCreationDto.getMaxMembers());
        byId.setStartDate(eventCreationDto.getStartDate());
        byId.setEndDate(eventCreationDto.getEndDate());
        byId.setDeadlineDecision(eventCreationDto.getDeadlineDecision());
        byId.setEventPlace(eventCreationDto.getEventPlace());
        byId.setParticipants(eventParticipants);
    }

    private List<EventParticipant> mapParticipants(EventCreationDto eventCreationDto) {
        List<EventParticipantDto> participants = eventCreationDto.getParticipants();

        List<EventParticipant> eventParticipants = new ArrayList<>();

        for (EventParticipantDto participant : participants) {
            EventParticipant eventParticipant = EventParticipant.builder()
                    .eventRole(participant.getEventRole())
                    .decision(participant.getDecision())
                    .appUser(userRepository.getById(participant.getUserId()))
                    .build();

            eventParticipants.add(eventParticipant);
        }

        return eventParticipants;

    }
}
