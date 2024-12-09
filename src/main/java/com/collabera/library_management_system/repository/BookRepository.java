package com.collabera.library_management_system.repository;

import com.collabera.library_management_system.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByIsbnNumber(String isbnNumnber);

}
