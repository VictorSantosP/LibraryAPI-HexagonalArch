package com.example.libraryApi.book.adapters.inbound.rest.mapper;

import com.example.libraryApi.book.adapters.inbound.rest.dto.BookResponse;
import com.example.libraryApi.book.adapters.inbound.rest.dto.CreateBookRequest;
import com.example.libraryApi.book.application.command.CreateBookCommand;
import com.example.libraryApi.book.domain.Book;
import org.springframework.stereotype.Component;

@Component
public class BookRestMapper {
    public CreateBookCommand toCommand(CreateBookRequest request) {
        return new CreateBookCommand(
                request.title(),
                request.author(),
                request.isbn(),
                request.publishedAt()
        );
    }

    public BookResponse toResponse(Book book) {
        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getIsbn(),
                book.getPublishedAt()
        );
    }
}
