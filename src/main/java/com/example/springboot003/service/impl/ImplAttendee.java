package com.example.springboot003.service.impl;

import com.example.springboot003.dto.model.Attendee;
import com.example.springboot003.dto.request.AttendeeRequest;
import com.example.springboot003.repository.AttendeeRepository;
import com.example.springboot003.service.AttendeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplAttendee implements AttendeeService {
    private final AttendeeRepository attendeeRepository;

    public ImplAttendee(AttendeeRepository attendeeRepository) {
        this.attendeeRepository = attendeeRepository;
    }

    @Override
    public Attendee addAttendee(AttendeeRequest attendee) {
        return attendeeRepository.addAttendee(attendee);
    }

    @Override
    public List<Attendee> getAllAttendees() {
        return attendeeRepository.getAllAttendees();
    }

    @Override
    public Attendee getAttendeeById(Integer id) {
        return attendeeRepository.getAttendeeById(id);
    }

    @Override
    public Attendee updateAttendee(Integer id,AttendeeRequest attendee) {
        return attendeeRepository.updateAttendee(id, attendee);
    }

    @Override
    public Attendee deleteAttendee(Integer id) {
        return attendeeRepository.deleteAttendee(id);
    }
}
