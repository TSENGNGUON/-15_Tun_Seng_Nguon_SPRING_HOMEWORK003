package com.example.springboot003.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenueRequest {
    @NotNull(message = "Must not be blank")
    @NotBlank(message = "Must not be blank")
    private String venueName;
    private String location;
}
