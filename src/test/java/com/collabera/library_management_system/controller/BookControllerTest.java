package com.collabera.library_management_system.controller;

import com.collabera.library_management_system.dto.BookDto;
import com.collabera.library_management_system.model.Book;
import com.collabera.library_management_system.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
public class BookControllerTest {

    @MockBean
    private BookService bookService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private BookDto bookDto;

    private Book book;

    @BeforeEach
    public void setup(){
        bookDto = new BookDto();
        bookDto.setId((long)1);
        bookDto.setAuthor("TestAuthor");
        bookDto.setTitle("TestTitle");
        bookDto.setIsbnNumber("12345");

        book = new Book();
        book.setReturn_Date(new Date());
        book.setBorrower_id(1);
        book.setBorrow_Date(new Date());
        book.setAuthor("TestAuthor");
        book.setIsbnNumber("12345");
        book.setTitle("TestTitle");

    }

    @Test
    public void testRegisterBook() throws Exception{

        when(bookService.registerBook(any(BookDto.class))).thenReturn(bookDto);

        mockMvc.perform( MockMvcRequestBuilders
                        .post("/v1/book").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(bookDto)))

                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(bookDto.getId()))
                .andExpect(jsonPath("$.title").value(bookDto.getTitle()))
                .andExpect(jsonPath("$.author").value(bookDto.getAuthor()))
                .andExpect(jsonPath("$.isbnNumber").value(bookDto.getIsbnNumber()));

    }


}
