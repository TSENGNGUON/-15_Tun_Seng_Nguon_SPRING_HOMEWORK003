package com.example.springboot003.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class apiResponse<T> {
private String message;
private T payload;
private HttpStatus status;
private LocalDateTime time;
}
