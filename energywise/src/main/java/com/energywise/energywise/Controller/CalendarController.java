package com.energywise.energywise.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    public String printHello() {
        return "Hello, Calendar!";
    }

    @PostMapping("/addEvent")
    public CalendarEntity addEvent(@RequestBody CalendarEntity event) {
        return calendarService.addEvent(event);
    }

    @GetMapping("/getAllEvents")
    public List<CalendarEntity> getAllEvents() {
        return calendarService.getAllEvents();
    }

    @GetMapping("/getEventById/{eventId}")
    public CalendarEntity getEventById(@PathVariable long eventId) {
        return calendarService.getEventById(eventId);
    }

    @PutMapping("/updateEvent/{eventId}")
    public CalendarEntity updateEvent(@PathVariable long eventId, @RequestBody CalendarEntity updatedEvent) {
        return calendarService.updateEvent(eventId, updatedEvent);
    }

    @DeleteMapping("/deleteEvent/{eventId}")
    public String deleteEvent(@PathVariable long eventId) {
        return calendarService.deleteEvent(eventId);
    }
}
