package com.envelo.integrationapp.services;

import com.envelo.integrationapp.model.dtos.EventCreationDto;
import com.envelo.integrationapp.model.dtos.info.EventDtoInfo;
import com.envelo.integrationapp.model.dtos.info.EventParticipantDtoInfo;
import com.envelo.integrationapp.model.dtos.info.EventPlaceDtoInfo;
import com.envelo.integrationapp.model.entities.Event;
import com.envelo.integrationapp.model.entities.EventParticipant;
import com.envelo.integrationapp.model.enums.EventRole;
import com.envelo.integrationapp.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

    public Event getEvent(long l) {


        Event byId = eventRepository.getById(10L);

        System.out.println(byId.getDeadlineDecision());
        System.out.println(byId.getDeadlineDecision());
        System.out.println(byId.getDeadlineDecision());

        return byId;
    }
    public List<EventDtoInfo> getAllUserCreatedEvents(Long userId, EventRole eventRole){
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
}
