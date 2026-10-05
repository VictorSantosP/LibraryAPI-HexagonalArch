package com.example.libraryApi.book.adapters.inbound.rest.dto;

import java.time.LocalDate;

public record BookResponse(
        Long id,
        String title,
        String author,
        String isbn,
        LocalDate publishedAt
) {
}
