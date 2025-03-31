package com.example.springboot003.controller;

import com.example.springboot003.dto.model.Attendee;
import com.example.springboot003.dto.model.Venue;
import com.example.springboot003.dto.request.AttendeeRequest;
import com.example.springboot003.dto.request.VenueRequest;
import com.example.springboot003.dto.response.apiResponse;
import com.example.springboot003.service.AttendeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/attendees")
public class AttendeeController {
    private final AttendeeService attendeeService;

    public AttendeeController(AttendeeService attendeeService) {
        this.attendeeService = attendeeService;
    }

    @PostMapping
    public ResponseEntity<apiResponse<Attendee>> addVenue(@Valid @RequestBody AttendeeRequest attendeeRequest) {
        apiResponse<Attendee> response = apiResponse.<Attendee>builder()
                .message("The attendee has been successfully added.")
                .payload(attendeeService.addAttendee(attendeeRequest))
                .status(HttpStatus.CREATED)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<apiResponse<List<Attendee>>> getAllAttendees() {
        apiResponse<List<Attendee>> response = apiResponse.<List<Attendee>>builder()
                .message("The attendee has been successfully added.")
                .payload(attendeeService.getAllAttendees())
                .status(HttpStatus.CREATED)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{attendee-id}")
    public ResponseEntity<apiResponse<Attendee>> getAttendeeById(@PathVariable("attendee-id") Integer attendeeId) {
        apiResponse<Attendee> response = apiResponse.<Attendee>builder()
                .message("The attendee has been successfully founded.")
                .payload(attendeeService.getAttendeeById(attendeeId))
                .status(HttpStatus.CREATED)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }


    @PutMapping("/{attendee-id}")
    public ResponseEntity<apiResponse<Attendee>> updateAttendee(@PathVariable("attendee-id") Integer id, @RequestBody AttendeeRequest attendeeRequest) {
        apiResponse<Attendee> response = apiResponse.<Attendee>builder()
                .message("The attendee has been successfully updated.")
                .payload(attendeeService.updateAttendee(id, attendeeRequest))
                .status(HttpStatus.CREATED)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{attendee-id}")
    public ResponseEntity<apiResponse<Attendee>> deleteAttendeeById(@PathVariable("attendee-id") Integer id) {
        apiResponse<Attendee> response = apiResponse.<Attendee>builder()
                .message("The attendee has been successfully updated.")
                .payload(attendeeService.deleteAttendee(id))
                .status(HttpStatus.CREATED)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }





}
