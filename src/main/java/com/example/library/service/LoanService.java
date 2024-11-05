package com.example.library.service;

import com.example.library.entity.Book;
import com.example.library.entity.Loan;
import com.example.library.entity.User;
import com.example.library.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {
    public final LoanRepository loanRepository;
    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }
    public Loan saveLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    public List<Loan> getLoansByUser(User user) {
        return loanRepository.findByUser(user);
    }

    public List<Loan> getLoansByBook(Book book) {
        return loanRepository.findByBook(book);
    }
}
