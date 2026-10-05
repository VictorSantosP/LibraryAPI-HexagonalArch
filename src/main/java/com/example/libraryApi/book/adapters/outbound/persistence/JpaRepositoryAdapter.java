package com.example.libraryApi.book.adapters.outbound.persistence;

import com.example.libraryApi.book.adapters.inbound.rest.mapper.BookPersistenceMapper;
import com.example.libraryApi.book.application.service.BookService;
import com.example.libraryApi.book.domain.Book;
import com.example.libraryApi.book.port.outbound.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class JpaRepositoryAdapter implements BookRepository {

    private final BookJpaRepository repository;
    private final BookPersistenceMapper mapper;

    @Override
    public Book save(Book book){

        BookEntity entity = mapper.toEntity(book);

        BookEntity saved = repository.save(entity);

        return mapper.toDomain(saved);
    }

    @Override
    public boolean existsByIsbn(String isbn){
        return repository.existsByIsbn(isbn);
    }
}
