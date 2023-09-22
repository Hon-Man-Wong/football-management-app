package com.createment.footballmanager.Match.Event;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Arrays;

@Service
public class EventService {
    private EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public ResponseEntity updateEvent(Integer eventId, Event updatedEvent) {
        return eventRepository.findById(eventId)
                .map(existingEvent -> {
                    Arrays.asList("timeStamp", "type", "player", "match")
                            .forEach(field -> {
                                Object updatedValue = getFieldValue(updatedEvent, field);
                                if (updatedValue != null) {
                                    setFieldValue(existingEvent, field, updatedValue);
                                }
                            });
                    return new ResponseEntity<>(eventRepository.save(existingEvent), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    private Object getFieldValue(Event event, String fieldName) {
        try {
            Field field = Event.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(event);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            return null;
        }
    }

    private void setFieldValue(Event event, String fieldName, Object value) {
        try {
            Field field = Event.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(event, value);
        } catch (NoSuchFieldException | IllegalAccessException ignored) {
        }
    }
}
