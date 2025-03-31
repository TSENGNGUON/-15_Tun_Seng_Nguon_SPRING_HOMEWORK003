package com.example.springboot003.repository;

import com.example.springboot003.dto.model.Event;
import com.example.springboot003.dto.request.EventRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EventRepository {
    @Select("""
    SELECT * FROM events
""")
    @Results(id = "getEventMapper", value = {
            @Result(property = "eventId", column = "event_id"),
            @Result(property = "eventName", column = "event_name"),
            @Result(property = "publishDate", column = "event_date"),
            @Result(property = "venue", column = "venue_id", one = @One(select = "com.example.springboot003.repository.VenueRepository.getVenueById")),
            @Result(property = "attendees", column = "event_id",
                    many = @Many(select = "com.example.springboot003.repository.AttendeeRepository.getAttendeeByEventId"))


    })
    List<Event> getAllEvents();

    @Select("""
    INSERT INTO events (event_name,event_date,venue_id) VALUES (#{request.eventName},#{request.publishDate}, #{request.venueId}) returning *;
""")
    @ResultMap("getEventMapper")
    Event createEvent(@Param("request") EventRequest eventRequest);


    @Select("""
    SELECT * FROM events WHERE event_id = #{eventId}
""")
    @ResultMap("getEventMapper")
    Event getEventById(Integer eventId);



}
