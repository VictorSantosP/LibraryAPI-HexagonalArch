package com.example.libraryApi.book.port.outbound;

import com.example.libraryApi.book.domain.Book;

import java.util.Optional;

public interface BookRepository {

    Book save(Book book);

    boolean existsByIsbn(String isbn);
}
