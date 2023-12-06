package com.energywise.energywise.Controller;

import java.util.ArrayList;
import java.util.List;

public class CalendarController {
    private List<Event> events;

    public CalendarController() {
        this.events = new ArrayList<>();
    }

    public void createEvent(String title, String description, boolean recurring, RecurrenceType recurrenceType) {
        Event event = new Event(title, description, recurring, recurrenceType);
        events.add(event);
        // Add any additional logic you may need
    }

    public void updateEvent(int eventId, String newTitle, String newDescription) {
        Event event = events.get(eventId);
        if (event != null) {
            event.setTitle(newTitle);
            event.setDescription(newDescription);
            // Add any additional logic you may need
        } else {
            // Handle the case where the event with the given ID is not found
        }
    }

    // Add more methods as needed

    private static class Event {
        private String title;
        private String description;
        private boolean recurring;
        private RecurrenceType recurrenceType;

        public Event(String title, String description, boolean recurring, RecurrenceType recurrenceType) {
            this.title = title;
            this.description = description;
            this.recurring = recurring;
            this.recurrenceType = recurrenceType;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        // Add getters and setters for other fields as needed
    }

    public enum RecurrenceType {
        DAILY,
        WEEKLY,
        MONTHLY,
        YEARLY
    }
}
