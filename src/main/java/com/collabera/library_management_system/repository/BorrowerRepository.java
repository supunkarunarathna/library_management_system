package com.collabera.library_management_system.repository;

import com.collabera.library_management_system.model.Book;
import com.collabera.library_management_system.model.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface BorrowerRepository extends JpaRepository<Borrower, Long> {
}
