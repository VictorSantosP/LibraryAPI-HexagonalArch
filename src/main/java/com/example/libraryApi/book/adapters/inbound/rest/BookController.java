package com.example.libraryApi.book.adapters.inbound.rest;


import com.example.libraryApi.book.adapters.inbound.rest.dto.BookResponse;
import com.example.libraryApi.book.adapters.inbound.rest.dto.CreateBookRequest;
import com.example.libraryApi.book.adapters.inbound.rest.mapper.BookRestMapper;
import com.example.libraryApi.book.application.command.CreateBookCommand;
import com.example.libraryApi.book.domain.Book;
import com.example.libraryApi.book.port.inbound.CreateBookUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final CreateBookUseCase createBookUseCase;
    private final BookRestMapper mapper;

    @PostMapping("/register-book")
    public ResponseEntity<BookResponse> create (@RequestBody CreateBookRequest request){

        CreateBookCommand cmd = mapper.toCommand(request);

        Book book = createBookUseCase.execute(cmd);

        BookResponse response = mapper.toResponse(book);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
