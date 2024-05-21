package com.collabera.library_management_system.service;

import com.collabera.library_management_system.model.Borrower;
import com.collabera.library_management_system.repository.BorrowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowerService {

    @Autowired
    private BorrowerRepository borrowerRepository;

    //Register borrower
    public Borrower registerBorrower (Borrower borrower){
        return borrowerRepository.save(borrower);
    }
}
