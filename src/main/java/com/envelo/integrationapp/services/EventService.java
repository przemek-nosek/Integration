package com.envelo.integrationapp.services;

import com.envelo.integrationapp.model.dtos.EventCreationDto;
<<<<<<< HEAD
import com.envelo.integrationapp.model.dtos.info.EventDtoInfo;
import com.envelo.integrationapp.model.entities.Event;
import com.envelo.integrationapp.model.entities.EventParticipant;
import com.envelo.integrationapp.model.enums.EventStatus;
=======
import com.envelo.integrationapp.model.dtos.EventParticipantDto;
import com.envelo.integrationapp.model.entities.AppUser;
import com.envelo.integrationapp.model.entities.Event;
import com.envelo.integrationapp.model.entities.EventParticipant;
>>>>>>> dev
import com.envelo.integrationapp.repositories.EventRepository;
import com.envelo.integrationapp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
=======
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
>>>>>>> dev
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class EventService {

    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    public Event addEvent(EventCreationDto eventCreationDto) {
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
        return save;
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
}
