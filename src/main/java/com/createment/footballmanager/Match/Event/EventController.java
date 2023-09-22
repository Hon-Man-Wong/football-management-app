package com.createment.footballmanager.Match.Event;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventController {
    private EventRepository eventRepository;
    private EventService eventService;

    public EventController(EventRepository eventRepository, EventService eventService) {
        this.eventRepository = eventRepository;
        this.eventService = eventService;
    }

    @GetMapping("/events")
    public List<Event> showAllEvents() {
        return eventRepository.findAll();
    }

    @GetMapping("/matches/{matchId}/events")
    public List<Event> showEventsByMatchId(@PathVariable Integer matchId) {
        return eventRepository.findAllEventsByMatchId(matchId);
    }

    @PostMapping("/events")
    public Event addEvent(@RequestBody Event event) {
        return eventRepository.save(event);
    }

    @PutMapping("/events/{eventId}")
    public ResponseEntity updateEvent(@PathVariable Integer eventId, @RequestBody Event event) {
        return eventService.updateEvent(eventId, event);
    }

    @DeleteMapping("/events/{eventId}")
    public void deleteEvent(@PathVariable Integer eventId) {
        eventRepository.deleteById(eventId);
    }
}
