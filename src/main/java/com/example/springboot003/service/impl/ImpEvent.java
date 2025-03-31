package com.example.springboot003.service.impl;

import com.example.springboot003.dto.model.Event;
import com.example.springboot003.dto.request.EventRequest;
import com.example.springboot003.repository.AttendeeRepository;
import com.example.springboot003.repository.EventRepository;
import com.example.springboot003.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpEvent implements EventService {
    private final EventRepository eventRepository;
    private final AttendeeRepository attendeeRepository;

    public ImpEvent(EventRepository eventRepository, AttendeeRepository attendeeRepository) {
        this.eventRepository = eventRepository;
        this.attendeeRepository = attendeeRepository;
    }

    @Override
    public Event createEvent(EventRequest eventRequest) {
        Event event = eventRepository.createEvent(eventRequest);
        for (Integer attendeeId : eventRequest.getAttendeesId()){
            attendeeRepository.addEventIdAndAttendeeId(eventRequest.getVenueId(), attendeeId);
        }
        return event;
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.getAllEvents();
    }

    @Override
    public Event getEventById(Integer eventId) {
        return eventRepository.getEventById(eventId);
    }
}
