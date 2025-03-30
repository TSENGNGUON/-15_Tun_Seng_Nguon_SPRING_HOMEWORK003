package com.example.springboot003.repository;

import com.example.springboot003.dto.model.Event;
import com.example.springboot003.dto.request.EventRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EventRepository {

    @Select("""
    
""")
    Event createEvent(@Param("request") EventRequest eventRequest);
}
