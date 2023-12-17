
package com.energywise.energywise.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energywise.energywise.Entity.CalendarEntity;
import com.energywise.energywise.Repository.CalendarRepository;

@Service
public class CalendarService {

    @Autowired
    private CalendarRepository calendarRepository;

    public CalendarEntity addEvent(CalendarEntity event) {
        return calendarRepository.save(event);
    }

    public List<CalendarEntity> getAllEvents() {
        return calendarRepository.findAll();
    }

    public CalendarEntity getEventById(long eventId) {
        Optional<CalendarEntity> optionalEvent = calendarRepository.findById((int) eventId);
        return optionalEvent.orElse(null);
    }

    public CalendarEntity updateEvent(long eventId, CalendarEntity updatedEvent) {
        Optional<CalendarEntity> optionalEvent = calendarRepository.findById((int) eventId);
        if (optionalEvent.isPresent()) {
            CalendarEntity existingEvent = optionalEvent.get();
            existingEvent.setEventName(updatedEvent.getEventName());
            existingEvent.setEventDate(updatedEvent.getEventDate());
            existingEvent.setEventDescription(updatedEvent.getEventDescription());
            return calendarRepository.save(existingEvent);
        } else {
            return null;
        }
    }

    public String deleteEvent(long eventId) {
        if (calendarRepository.existsById((int) eventId)) {
            calendarRepository.deleteById((int) eventId);
            return "Success";
        } else {
            return "Event not found";
        }
    }
}
