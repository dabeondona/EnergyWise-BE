package com.energywise.energywise.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calendar")
public class CalendarController {

    private final List<CalendarEvent> events = new ArrayList<>();

    @GetMapping("/print")
    public String printHello() {
        return "Hello, Adrian Sepulveda!";
    }

    @PostMapping("/create")
    public ResponseEntity<String> createEvent(@RequestBody CalendarEvent event) {
        events.add(event);
        return new ResponseEntity<>("Event created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/update/{eventId}")
    public ResponseEntity<String> updateEvent(@PathVariable Long eventId, @RequestBody CalendarEvent updatedEvent) {
        CalendarEvent existingEvent = findEventById(eventId);

        if (existingEvent != null) {
            existingEvent.setTime(updatedEvent.getTime());
            existingEvent.setTimezone(updatedEvent.getTimezone());

            return new ResponseEntity<>("Event updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Event not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{eventId}")
    public ResponseEntity<String> deleteEvent(@PathVariable Long eventId) {
        CalendarEvent eventToDelete = findEventById(eventId);

        if (eventToDelete != null) {
            events.remove(eventToDelete);
            return new ResponseEntity<>("Event deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Event not found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/createRecurring")
    public ResponseEntity<String> createRecurringEvent(@RequestBody CalendarEvent recurringEvent) {
        events.add(recurringEvent);
        return new ResponseEntity<>("Recurring event created successfully", HttpStatus.CREATED);
    }

    private CalendarEvent findEventById(Long eventId) {
        return events.stream()
                .filter(event -> event.getEventId().equals(eventId))
                .findFirst()
                .orElse(null);
    }

    static class CalendarEvent {
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        private Date time;

        private String timezone;
        private Long eventId; // Assuming eventId is a unique identifier

        // Getter and Setter methods for time, timezone, and eventId

        public Long getEventId() {
            return eventId;
        }

        public Date getTime() {
            return time;
        }

        public void setTime(Date time) {
            this.time = time;
        }

        public String getTimezone() {
            return timezone;
        }

        public void setTimezone(String timezone) {
            this.timezone = timezone;
        }
    }
}