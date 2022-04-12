package com.envelo.integrationapp.controllers;

import com.envelo.integrationapp.model.dtos.EventCreationDto;
import com.envelo.integrationapp.model.dtos.info.EventDtoInfo;
import com.envelo.integrationapp.model.entities.Event;
import com.envelo.integrationapp.model.enums.EventStatus;
import com.envelo.integrationapp.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @GetMapping
    public Event getEvent(){
        return eventService.getEvent(1L);
    }

    @PostMapping
    public Event addEvent(@RequestBody EventCreationDto eventCreationDto) {
        return eventService.addEvent(eventCreationDto);
    }

    @GetMapping("/{userId}/status/eventStatus")
    public Set<EventDtoInfo> getUserEventsByEventStatus(@PathVariable long userId, @RequestParam EventStatus eventStatus) {
        return eventService.getEventByUserStatus(userId, eventStatus);
    }
}
