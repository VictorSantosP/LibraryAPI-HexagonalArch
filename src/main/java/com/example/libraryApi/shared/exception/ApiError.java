package com.example.libraryApi.shared.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ApiError (
        @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
        LocalDateTime timestamp,

        Integer code,

        String status,

        String message,

        String path
) {


}
