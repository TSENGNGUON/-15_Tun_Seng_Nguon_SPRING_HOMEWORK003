package com.example.springboot003.service;

import com.example.springboot003.dto.model.Venue;
import com.example.springboot003.dto.request.VenueRequest;

import java.util.List;

public interface VenueService {
     Venue addVenue(VenueRequest venueRequest);
     List<Venue> getAllVenues();
     Venue getVenueById(Integer venueId);
     Venue updateVenue(Integer venueId, VenueRequest venueRequest);
     Venue deleteByid(Integer venueId);
}

