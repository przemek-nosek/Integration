package com.envelo.integrationapp.controllers;

import com.envelo.integrationapp.model.dtos.EventCreationDto;
import com.envelo.integrationapp.model.dtos.info.EventDtoInfo;
import com.envelo.integrationapp.model.entities.Event;
import com.envelo.integrationapp.model.enums.EventStatus;
import com.envelo.integrationapp.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @PostMapping
    public Event addEvent(@RequestBody EventCreationDto eventCreationDto) {
        return eventService.addEvent(eventCreationDto);
    }

    @GetMapping("/{userId}/status/eventStatus")
    public Set<EventDtoInfo> getUserEventsByEventStatus(@PathVariable long userId, @RequestParam EventStatus eventStatus) {
        return eventService.getEventByUserStatus(userId, eventStatus);
    }

    @GetMapping("/{id}/event")
    public EventDtoInfo getEventById(@PathVariable long id) {
        return eventService.getEventById(id);
    }
}
