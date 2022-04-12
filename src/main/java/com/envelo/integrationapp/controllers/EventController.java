package com.envelo.integrationapp.controllers;

import com.envelo.integrationapp.model.dtos.EventCreationDto;
import com.envelo.integrationapp.model.entities.Event;
import com.envelo.integrationapp.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @PostMapping
    public Event addEvent(@RequestBody EventCreationDto eventCreationDto) {
        System.out.println(LocalDateTime.now());

        return eventService.addEvent(eventCreationDto);
    }

}
