package com.createment.footballmanager.Match.Event;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventController {
    private EventRepository eventRepository;

    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @GetMapping("matches/{matchId}/events")
    public List<Event> showEventsByMatchId(@PathVariable Integer matchId) {
        return eventRepository.findAllEventsByMatchId(matchId);
    }

}
