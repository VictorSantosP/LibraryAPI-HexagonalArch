package com.example.libraryApi.book.application.service;

import com.example.libraryApi.book.application.command.CreateBookCommand;
import com.example.libraryApi.book.domain.Book;
import com.example.libraryApi.book.port.inbound.CreateBookUseCase;
import com.example.libraryApi.book.port.outbound.BookRepository;
import com.example.libraryApi.shared.exception.BookAlreadyExistsException;
import org.springframework.stereotype.Service;

@Service
public class BookService implements CreateBookUseCase {

    private final BookRepository repo;

    public BookService(BookRepository repo){
        this.repo = repo;
    }

    @Override
    public Book execute(CreateBookCommand cmd){
        if(repo.existsByIsbn(cmd.isbn())){
            throw new BookAlreadyExistsException("Book already exists");
        }
        try{
            Book book = new Book(
                    null,
                    cmd.title(),
                    cmd.author(),
                    cmd.isbn(),
                    cmd.publishedAt()
            );

            return repo.save(book);

        } catch (RuntimeException e){
            throw new RuntimeException("Unexpected error!");
        }
    }
}
