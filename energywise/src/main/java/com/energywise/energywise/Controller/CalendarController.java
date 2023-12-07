package com.energywise.energywise.Controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calendar")
public class CalendarController {

    private final List<Calendar> events = new ArrayList<>();

    @PostMapping("/create")
    public ResponseEntity<String> createEvent(@RequestBody Calendar event) {
        events.add(event); // Corrected method name to 'events.add'
        return new ResponseEntity<>("Event created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/update/eventId")
    public ResponseEntity<String> updateEvent(@PathVariable Long eventId, @RequestBody Calendar updatedEvent) {
        Calendar existingEvent = findEventById(eventId);

        if (existingEvent != null) {
            // Update the event time
            existingEvent.setTime(updatedEvent.getTime());

            return new ResponseEntity<>("Event updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Event not found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/createRecurring")
    public ResponseEntity<String> createRecurringEvent(@RequestBody Calendar recurringEvent) {
        events.add(recurringEvent); // Corrected method name to 'events.add'
        return new ResponseEntity<>("Recurring event created successfully", HttpStatus.CREATED);
    }

    private Calendar findEventById(Long eventId) {
        return events.stream()
                .filter(event -> event.getCalendarType().equals(eventId)) // Corrected method to get eventId
                .findFirst()
                .orElse(null);
    }
}
