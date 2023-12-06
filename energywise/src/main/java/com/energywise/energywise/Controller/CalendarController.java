package com.energywise.energywise.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/api/calendar")
public class CalendarController {

    private final List<Calendar> events = new ArrayList<>();

    @PostMapping("/create")
    public ResponseEntity<String> createEvent(@RequestBody Calendar event) {
        events.add(event); // Corrected method name to 'events.add'
        return new ResponseEntity<>("Event created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/update/{eventId}")
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
