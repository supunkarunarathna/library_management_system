package com.collabera.library_management_system.controller;

import com.collabera.library_management_system.dto.BookDto;
import com.collabera.library_management_system.model.Borrower;
import com.collabera.library_management_system.service.BookService;
import com.collabera.library_management_system.service.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/borrower")
public class BorrowerController {

    @Autowired
    private BorrowerService borrowerService;

    //Register new Borrower
    @PostMapping
    public Borrower registerBorrower(@RequestBody Borrower borrower){
        return borrowerService.registerBorrower(borrower);
    }
}
