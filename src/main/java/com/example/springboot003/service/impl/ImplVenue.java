package com.example.springboot003.service.impl;

import com.example.springboot003.dto.model.Venue;
import com.example.springboot003.dto.request.VenueRequest;
import com.example.springboot003.repository.VenueRepository;
import com.example.springboot003.service.VenueService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplVenue implements VenueService {
    private final VenueRepository venueRepository;

    public ImplVenue(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }

    @Override
    public Venue addVenue(VenueRequest venueRequest) {
        return venueRepository.addVenue(venueRequest);
    }

    @Override
    public List<Venue> getAllVenues() {
        return venueRepository.getAllVenues();
    }

    @Override
    public Venue getVenueById(Integer venueId) {
        return venueRepository.getVenueById(venueId);
    }

    @Override
    public Venue updateVenue(Integer venueId, VenueRequest venueRequest) {
        return venueRepository.updateVenue(venueId, venueRequest);
    }

    @Override
    public Venue deleteByid(Integer venueId) {
        return venueRepository.deleteVenueById(venueId);
    }
}
