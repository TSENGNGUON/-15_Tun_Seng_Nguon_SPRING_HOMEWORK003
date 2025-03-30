package com.example.springboot003.controller;

import  com.example.springboot003.dto.model.Venue;
import com.example.springboot003.dto.request.VenueRequest;
import com.example.springboot003.dto.response.apiResponse;
import com.example.springboot003.service.VenueService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/venues")
public class VenuesController {
    private final VenueService venueService;

    public VenuesController(VenueService venueService) {
        this.venueService = venueService;
    }

    @PostMapping
    public ResponseEntity<apiResponse<Venue>> addVenue(@Valid @RequestBody VenueRequest venueRequest) {
        apiResponse<Venue> response = apiResponse.<Venue>builder()
                .message("The venue has been successfully added.")
                .payload(venueService.addVenue(venueRequest))
                .status(HttpStatus.CREATED)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<apiResponse<List<Venue>>> getAllVenues() {
        apiResponse<List<Venue>> response = apiResponse.<List<Venue>>builder()
                .message("All venues have been successfully fetched.")
                .payload(venueService.getAllVenues())
                .status(HttpStatus.CREATED)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{venue-id}")
    public  ResponseEntity<apiResponse<Venue>> getVenueById(@PathVariable("venue-id") Integer venueId){
        apiResponse<Venue> response = apiResponse.<Venue>builder()
                .message("All venues have been successfully fetched.")
                .payload(venueService.getVenueById(venueId))
                .status(HttpStatus.CREATED)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }


    @PutMapping("/{venue-id}")
    public ResponseEntity<apiResponse<Venue>> updateVenueById(@PathVariable("venue-id") Integer venueId, @RequestBody VenueRequest venueRequest){
        apiResponse<Venue> response = apiResponse.<Venue>builder()
                .message("All venues have been successfully Updated.")
                .payload(venueService.updateVenue(venueId, venueRequest))
                .status(HttpStatus.CREATED)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{venue-id}")
    public ResponseEntity<apiResponse<Venue>> deleteVenueById(@PathVariable("venue-id") Integer venueId){
        apiResponse<Venue> response = apiResponse.<Venue>builder()
                .message("The venue has been successfully deleted.")
                .payload(venueService.deleteByid(venueId))
                .status(HttpStatus.CREATED)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }
}
