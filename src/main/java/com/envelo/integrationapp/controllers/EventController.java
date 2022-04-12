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
    public void addEvent(@RequestBody EventCreationDto eventCreationDto) {
        eventService.addEvent(eventCreationDto);
    }

    @PutMapping("/{id}")
    public void updateEvent(@RequestBody EventCreationDto eventCreationDto, @PathVariable Long id) {
        eventService.updateEvent(id, eventCreationDto);
    }

    @GetMapping("/{userId}/status/eventStatus")
    public Set<EventDtoInfo> getUserEventsByEventStatus(@PathVariable long userId, @RequestParam EventStatus eventStatus) {
        return eventService.getEventByUserStatus(userId, eventStatus);
    }
}
