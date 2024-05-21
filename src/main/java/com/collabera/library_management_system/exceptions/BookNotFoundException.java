package com.collabera.library_management_system.exceptions;

public class BookNotFoundException extends RuntimeException{

    public BookNotFoundException(String message) {
        super("Book not found" + message);
    }

}
