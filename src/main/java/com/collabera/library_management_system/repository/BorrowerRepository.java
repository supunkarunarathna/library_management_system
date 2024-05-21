package com.collabera.library_management_system.repository;

import com.collabera.library_management_system.model.Book;
import com.collabera.library_management_system.model.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowerRepository extends JpaRepository<Borrower, Long> {
}
