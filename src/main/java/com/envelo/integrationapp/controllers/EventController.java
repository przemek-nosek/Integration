package com.envelo.integrationapp.controllers;

import com.envelo.integrationapp.model.dtos.EventCreationDto;
import com.envelo.integrationapp.model.entities.Event;
import com.envelo.integrationapp.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
}
