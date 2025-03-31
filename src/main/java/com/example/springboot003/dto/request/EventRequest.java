package com.example.springboot003.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventRequest {
    private Integer venueId;
    private String eventName;
    private LocalDateTime publishDate;
    private List<Integer> attendeesId;
}