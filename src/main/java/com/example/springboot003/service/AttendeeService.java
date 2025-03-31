package com.example.springboot003.service;

import com.example.springboot003.dto.model.Attendee;
import com.example.springboot003.dto.request.AttendeeRequest;

import java.util.List;

public interface AttendeeService {
    Attendee addAttendee(AttendeeRequest attendee);
    List<Attendee> getAllAttendees();
    Attendee getAttendeeById(Integer id);
    Attendee updateAttendee(Integer id,AttendeeRequest attendee);
    Attendee deleteAttendee(Integer id);


}
