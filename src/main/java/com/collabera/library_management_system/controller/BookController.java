package com.collabera.library_management_system.controller;


import com.collabera.library_management_system.dto.BookDto;
import com.collabera.library_management_system.model.Book;
import com.collabera.library_management_system.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/book")
public class BookController {

    @Autowired
    private BookService bookService;

    //Register new book
    @PostMapping
    public BookDto registerBook(@RequestBody BookDto bookDto){
        return bookService.registerBook(bookDto);
    }

    //Return all books
    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    //Borrow a book
    @PostMapping("/borrow/{isbnNumber}/{userId}")
    public Book borrowBook(@PathVariable String isbnNumber, @PathVariable int userId){

        return bookService.borrowBook(isbnNumber, userId);
    }

    @PostMapping("/return/{bookId}")
    public Book returnBook(@PathVariable int bookId){

        return bookService.returnBook(bookId);

    }
}
