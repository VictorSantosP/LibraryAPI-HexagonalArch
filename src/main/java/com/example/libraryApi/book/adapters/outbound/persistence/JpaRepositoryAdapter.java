package com.example.libraryApi.book.adapters.outbound.persistence;

import com.example.libraryApi.book.application.service.BookService;
import com.example.libraryApi.book.domain.Book;
import com.example.libraryApi.book.port.outbound.BookRepository;
import org.springframework.stereotype.Repository;

@Repository
public class JpaRepositoryAdapter implements BookRepository {

    private final BookJpaRepository repository;

    public JpaRepositoryAdapter (BookJpaRepository repository){
        this.repository = repository;
    }

    @Override
    public Book save(Book book){

        BookEntity entity = new BookEntity(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getIsbn(),
                book.getPublishedAt()
        );

        BookEntity saved = repository.save(entity);

        return new Book(
                saved.getId(),
                saved.getTitle(),
                saved.getAuthor(),
                saved.getIsbn(),
                saved.getPublishedAt()
        );
    }

    @Override
    public boolean existsByIsbn(String isbn){
        return repository.existsByIsbn(isbn);
    }
}
