package com.energywise.energywise.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.energywise.energywise.Entity.CalendarEntity;
import com.energywise.energywise.Service.CalendarService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/calendar")
public class CalendarController {

    @Autowired
    CalendarService calendarService;

    @GetMapping("/print")
    public ResponseEntity<String> printHello() {
        return ResponseEntity.ok("Hello, Calendar!");
    }

    @PostMapping("/addEvent")
    public ResponseEntity<CalendarEntity> addEvent(@RequestBody CalendarEntity event) {
        try {
            CalendarEntity addedEvent = calendarService.addEvent(event);
            return ResponseEntity.status(HttpStatus.CREATED).body(addedEvent);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/getAllEvents")
    public ResponseEntity<List<CalendarEntity>> getAllEvents() {
        List<CalendarEntity> events = calendarService.getAllEvents();
        return ResponseEntity.ok(events);
    }

    @GetMapping("/getEventById/{eventId}")
    public ResponseEntity<CalendarEntity> getEventById(@PathVariable long eventId) {
        CalendarEntity event = calendarService.getEventById(eventId);
        if (event != null) {
            return ResponseEntity.ok(event);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/updateEvent/{eventId}")
    public ResponseEntity<CalendarEntity> updateEvent(@PathVariable long eventId,
            @RequestBody CalendarEntity updatedEvent) {
        try {
            CalendarEntity event = calendarService.updateEvent(eventId, updatedEvent);
            if (event != null) {
                return ResponseEntity.ok(event);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/deleteEvent/{eventId}")
    public ResponseEntity<String> deleteEvent(@PathVariable long eventId) {
        String result = calendarService.deleteEvent(eventId);
        if (result.equals("Success")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
