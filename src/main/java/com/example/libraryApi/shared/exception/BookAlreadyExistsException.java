package com.example.libraryApi.shared.exception;

public class BookAlreadyExistsException extends RuntimeException{
    public BookAlreadyExistsException(String message){
        super(message);
    }
}
