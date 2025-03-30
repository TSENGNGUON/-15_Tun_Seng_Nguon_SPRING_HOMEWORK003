package com.example.springboot003.controller;

import com.example.springboot003.dto.model.Event;
import com.example.springboot003.dto.request.EventRequest;
import com.example.springboot003.dto.response.apiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/events")
public class EventController {
    @PostMapping
    public ResponseEntity<apiResponse<Event>> createEvent(@RequestBody EventRequest event) {
        return null;
    }
}
