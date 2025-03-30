package com.example.springboot003.service;

import com.example.springboot003.dto.model.Venue;
import com.example.springboot003.dto.request.VenueRequest;

import java.util.List;

public interface VenueService {
    public Venue addVenue(VenueRequest venueRequest);
    public List<Venue> getAllVenues();
    public Venue getVenueById(Integer venueId);
    public Venue updateVenue(Integer venueId, VenueRequest venueRequest);
}

