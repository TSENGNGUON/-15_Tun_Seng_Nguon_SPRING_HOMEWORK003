package com.example.springboot003.service;

import com.example.springboot003.dto.model.Event;
import com.example.springboot003.dto.request.EventRequest;

public interface EventService {
    Event createEvent(EventRequest eventRequest);
}
