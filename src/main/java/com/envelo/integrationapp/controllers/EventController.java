package com.envelo.integrationapp.controllers;

import com.envelo.integrationapp.model.dtos.EventCreationDto;
import com.envelo.integrationapp.model.dtos.info.EventDtoInfo;
import com.envelo.integrationapp.model.entities.Event;

import com.envelo.integrationapp.model.enums.Decision;
import com.envelo.integrationapp.model.enums.EventRole;
import com.envelo.integrationapp.model.enums.EventStatus;

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

    @PutMapping("/{eventId}/users/{userId}")
    public void updateEvent(@PathVariable Long eventId, @PathVariable Long userId, @RequestParam Decision decision) {
        eventService.changeUserDecision(eventId, userId, decision);
    }

    @GetMapping("/created/{id}")
    public List<EventDtoInfo> getCreatedEvents(@PathVariable Long id) {
        return eventService.getAllUserCreatedEvents(id, EventRole.HOST);
    }


    @GetMapping("/{userId}/status/eventStatus")
    public Set<EventDtoInfo> getUserEventsByEventStatus(@PathVariable long userId, @RequestParam EventStatus eventStatus) {
        return eventService.getEventByUserStatus(userId, eventStatus);
    }

    @GetMapping("/{id}/event")
    public EventDtoInfo getEventById(@PathVariable long id) {
        return eventService.getEventById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteEventById(@PathVariable long id) {
        eventService.deleteEvent(id);
    }
}
