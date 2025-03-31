package com.example.springboot003.service;

import com.example.springboot003.dto.model.Event;
import com.example.springboot003.dto.request.EventRequest;

import java.util.List;

public interface EventService {
    Event createEvent(EventRequest eventRequest);
    List<Event> getAllEvents();
    Event getEventById(Integer eventId);
}
