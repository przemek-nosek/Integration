package com.envelo.integrationapp.controllers;

import com.envelo.integrationapp.model.dtos.EventCreationDto;
import com.envelo.integrationapp.model.dtos.info.EventDtoInfo;
import com.envelo.integrationapp.model.entities.Event;
import com.envelo.integrationapp.model.enums.EventRole;
import com.envelo.integrationapp.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.beans.support.PagedListHolder.DEFAULT_PAGE_SIZE;

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

    @GetMapping
    public List<EventDtoInfo> getCreatedEvents() {
            return eventService.getAllUserCreatedEvents(1L, EventRole.HOST);
    }
}
