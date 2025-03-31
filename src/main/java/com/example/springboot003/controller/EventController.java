package com.example.springboot003.controller;

import com.example.springboot003.dto.model.Event;
import com.example.springboot003.dto.model.Venue;
import com.example.springboot003.dto.request.EventRequest;
import com.example.springboot003.dto.response.apiResponse;
import com.example.springboot003.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public ResponseEntity<apiResponse<Event>> createEvent(@RequestBody EventRequest event) {
        apiResponse<Event> response = apiResponse.<Event>builder()
                .message("The event has been successfully added.")
                .payload(eventService.createEvent(event))
                .status(HttpStatus.CREATED)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<apiResponse<List<Event>>> getAllEvents() {
        apiResponse<List<Event>> response = apiResponse.<List<Event>>builder()
                .message("The venue has been successfully added.")
                .payload(eventService.getAllEvents())
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{event-id}")
    public ResponseEntity<apiResponse<Event>> getEventById(@PathVariable("event-id") Integer eventId){
        apiResponse<Event> response = apiResponse.<Event>builder()
                .message("The event has been successfully founded.")
                .payload(eventService.getEventById(eventId))
                .status(HttpStatus.CREATED)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{event-id}")
    public ResponseEntity<apiResponse<Event>> updateEvent(@PathVariable("event-id") Integer eventId, @RequestBody EventRequest event){
        return null;
    }
}
