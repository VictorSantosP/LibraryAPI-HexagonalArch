package com.example.libraryApi.book.application.command;

import java.time.LocalDate;

public record CreateBookCommand (
        String title,
        String author,
        String isbn,
        LocalDate publishedAt
) {}
