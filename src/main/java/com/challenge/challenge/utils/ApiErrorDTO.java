package com.challenge.challenge.utils;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ApiErrorDTO {

    private HttpStatus status;
    private String message;
}
