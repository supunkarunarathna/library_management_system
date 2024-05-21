package com.collabera.library_management_system.service;

import com.collabera.library_management_system.dto.BookDto;
import com.collabera.library_management_system.exceptions.BookNotFoundException;
import com.collabera.library_management_system.model.Book;
import com.collabera.library_management_system.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    private ModelMapper modelMapper = new ModelMapper();

    //Register book service
    public BookDto registerBook(BookDto bookDto){

        Book book = this.modelMapper.map(bookDto, Book.class);

        return this.modelMapper.map(bookRepository.save(book), BookDto.class);

    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book borrowBook(String isbnNumber, int userId){

        //First check whether the book is available in the library using isbn number
        List<Book> books = bookRepository.findByIsbnNumber(isbnNumber);

        if(books.isEmpty()){
            throw new BookNotFoundException(isbnNumber);
        }

        //If the book exist, then check the stocks
        Optional<Book> availableBooks = books.stream()
                .filter(book -> (book.getReturn_Date() == null || book.getBorrow_Date() == null) || (book.getReturn_Date() != null))
                .findFirst();

        Book book = availableBooks.orElse(null);

        if(book != null){
            book.setBorrow_Date(new Date());
            book.setBorrower_id(userId);
        }

        return bookRepository.save(book);

    }

    public Book returnBook(int bookId){

        //Get the book details from the DB using bookId to update the return date there.
        Book book = bookRepository.findById((long)bookId).orElseThrow(() -> new BookNotFoundException(String.valueOf(bookId)));

        //Set the return date
        book.setReturn_Date(new Date());
        return bookRepository.save(book);
    }





}
