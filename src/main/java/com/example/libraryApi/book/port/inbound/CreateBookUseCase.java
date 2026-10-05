package com.example.libraryApi.book.port.inbound;

import com.example.libraryApi.book.application.command.CreateBookCommand;
import com.example.libraryApi.book.domain.Book;

public interface CreateBookUseCase {
    Book execute(CreateBookCommand cmd);
}
