package com.example.libraryApi.book.adapters.inbound.rest.mapper;

import com.example.libraryApi.book.adapters.outbound.persistence.BookEntity;
import com.example.libraryApi.book.domain.Book;
import org.springframework.stereotype.Component;

@Component
public class BookPersistenceMapper {

    public BookEntity toEntity(Book book){
        return new BookEntity(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getIsbn(),
                book.getPublishedAt()
        );
    }

    public Book toDomain(BookEntity bookEntity){
        return new Book(
                bookEntity.getId(),
                bookEntity.getTitle(),
                bookEntity.getAuthor(),
                bookEntity.getIsbn(),
                bookEntity.getPublishedAt()
        );
    }
}
