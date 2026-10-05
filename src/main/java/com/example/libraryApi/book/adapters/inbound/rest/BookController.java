package com.example.libraryApi.book.adapters.inbound.rest;


import com.example.libraryApi.book.adapters.inbound.rest.dto.CreateBookRequest;
import com.example.libraryApi.book.application.command.CreateBookCommand;
import com.example.libraryApi.book.domain.Book;
import com.example.libraryApi.book.port.inbound.CreateBookUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    private final CreateBookUseCase createBookUseCase;

    public BookController(CreateBookUseCase createBookUseCase){
        this.createBookUseCase = createBookUseCase;
    }

    @PostMapping("/register-book")
    public ResponseEntity<Book> create (@RequestBody CreateBookRequest request){

        CreateBookCommand cmd = new CreateBookCommand(
                request.title(),
                request.author(),
                request.isbn(),
                request.publishedAt()
        );

        Book book = createBookUseCase.execute(cmd);

        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }

}
