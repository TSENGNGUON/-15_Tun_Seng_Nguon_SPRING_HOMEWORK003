package com.example.springboot003.dto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    private Integer eventId;
    private Integer venueId;
    private String eventName;
    private String eventDate;
    private List<Integer> venueIds;
}
