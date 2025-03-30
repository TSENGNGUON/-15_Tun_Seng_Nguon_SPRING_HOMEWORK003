package com.example.springboot003.repository;

import com.example.springboot003.dto.model.Venue;
import com.example.springboot003.dto.request.VenueRequest;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
public interface VenueRepository {

    @Select("""
        INSERT INTO venues(venue_name,location) VALUES (#{request.venueName}, #{request.location}) returning *
""")
    @Results(id = "venueMapper", value = {
            @Result( property = "venueName", column = "venue_name"),
            @Result( property = "venueId", column = "venue_id")
    })
    public Venue addVenue(@Param("request") VenueRequest  venueRequest);


    @Select("""
    SELECT * FROM venues;
""")
    @ResultMap("venueMapper")
    public List<Venue> getAllVenues();


    @Select("""
    SELECT * FROM venues WHERE venue_id = #{venueId};
""")
    @ResultMap("venueMapper")
    public Venue getVenueById(@Param("venueId") int venueId);

    @Select("""
    UPDATE venues SET venue_name = #{request.venueName}, location = #{request.location} WHERE venue_id = #{venueId} returning *;
""")
    @ResultMap("venueMapper")
    public Venue updateVenue(Integer venueId, @Param("request") VenueRequest venueRequest);


    @Select("""
    DELETE FROM venues WHERE venue_id = #{venueId} returning *;
    """)
    @ResultMap("venueMapper")
    public Venue deleteVenueById(@Param("venueId") Integer venueId);

}
