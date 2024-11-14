package com.example.library.controller;

import com.example.library.entity.Book;
import com.example.library.entity.Loan;
import com.example.library.entity.User;
import com.example.library.service.BookService;
import com.example.library.service.LoanService;
import com.example.library.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    private final LoanService loanService;
    private final BookService bookService;
    private final UserService userService;

    public LoanController(LoanService loanService, BookService bookService, UserService userService) {
        this.loanService = loanService;
        this.bookService = bookService;
        this.userService = userService;
    }

    @GetMapping
    public List<Loan> listLoans() {
        return loanService.getAllLoans();
    }

    @PostMapping
    public Loan createLoan(@RequestBody Loan loan) {
        return loanService.saveLoan(loan);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Loan> getLoanById(@PathVariable Long id) {
        Loan loan = loanService.getLoanById(id);
        if (loan != null) {
            return ResponseEntity.ok(loan);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Loan> editLoan(@PathVariable Long id, @RequestBody Loan loan) {
        Loan existingLoan = loanService.getLoanById(id);
        if (existingLoan != null) {
            loan.setId(id);
            return ResponseEntity.ok(loanService.saveLoan(loan));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoan(@PathVariable Long id) {
        Loan loan = loanService.getLoanById(id);
        if (loan != null) {
            loanService.deleteLoan(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/user/{userId}")
    public List<Loan> getLoansByUser(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        if (user != null) {
            return loanService.getLoansByUser(user);
        } else {
            return List.of();
        }
    }

    @GetMapping("/book/{bookId}")
    public List<Loan> getLoansByBook(@PathVariable Long bookId) {
        Book book = bookService.getBookById(bookId);
        if (book != null) {
            return loanService.getLoansByBook(book);
        } else {
            return List.of();
        }
    }
}