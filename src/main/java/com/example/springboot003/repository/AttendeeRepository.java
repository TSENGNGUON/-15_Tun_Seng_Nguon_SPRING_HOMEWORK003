package com.example.springboot003.repository;

import com.example.springboot003.dto.model.Attendee;
import com.example.springboot003.dto.request.AttendeeRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AttendeeRepository {
    @Select("""
    INSERT INTO attendees (attendee_name,email) VALUES (#{request.attendeeName},#{request.email})
    returning *
""")
    @Results(id = "attendeeMapper", value = {
            @Result(property = "attendeeName", column = "attendee_name"),
            @Result(property = "attendeeId", column = "attendee_id")
    })
    public Attendee addAttendee(@Param("request") AttendeeRequest attendee);


    @Select("""
     SELECT * FROM attendees 
""")
    @ResultMap("attendeeMapper")
    public List<Attendee> getAllAttendees();

    @Select("""
    SELECT * FROM attendees WHERE attendee_id = #{attendeeId}
""")
    @ResultMap("attendeeMapper")
    public Attendee getAttendeeById(Integer attendeeId);


    @Select("""
    UPDATE attendees SET attendee_name = #{request.attendeeName}, email = #{request.email} WHERE attendee_id = #{id} returning *
""")
    @ResultMap("attendeeMapper")
    Attendee updateAttendee(Integer id, @Param("request") AttendeeRequest attendee);


    @Select("""
    DELETE from attendees WHERE attendee_id = #{id} returning *
""")
    @ResultMap("attendeeMapper")
    Attendee deleteAttendee(Integer id);


    @Select("""
   SELECT a.* FROM
   event_attendee ea
   INNER JOIN public.attendees a
     ON a.attendee_id = ea.attendee_id
     WHERE event_id = #{eventId};                                  
""")
    @ResultMap("attendeeMapper")
    List<Attendee> getAttendeeByEventId(Integer eventId);


    @Insert("""
    INSERT INTO event_attendee(event_id,attendee_id) VALUES (#{eventId},#{attendeeId});
""")
    void addEventIdAndAttendeeId(Integer eventId, Integer attendeeId);
}
