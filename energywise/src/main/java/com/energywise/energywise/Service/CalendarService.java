package com.energywise.energywise.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energywise.energywise.Entity.CalendarEntity;
import com.energywise.energywise.Repository.CalendarRepository;

@Service
public class CalendarService {

    @Autowired
    private CalendarRepository calendarRepo;

    public CalendarEntity createEvent(CalendarEntity event) {
        return calendarRepo.save(event);
    }

    public List<CalendarEntity> getAllEvents() {
        return calendarRepo.findAll();
    }

    public CalendarEntity updateEvent(Integer eventId, CalendarEntity updatedEvent) {
        Optional<CalendarEntity> optionalEvent = calendarRepo.findById(eventId);

        if (optionalEvent.isPresent()) {
            CalendarEntity event = optionalEvent.get();
            return calendarRepo.save(event);
        } else {
            throw new NoSuchElementException("Event with ID " + eventId + " not found!");
        }
    }

    public String deleteEvent(Integer eventId) {
        Optional<CalendarEntity> optionalEvent = calendarRepo.findById(eventId);

        if (optionalEvent.isPresent()) {
            calendarRepo.deleteById(eventId);
            return "Event with ID " + eventId + " has been deleted.";
        } else {
            throw new NoSuchElementException("Event with ID " + eventId + " not found!");
        }
    }
}
