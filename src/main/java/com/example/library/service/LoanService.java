package com.example.library.service;

import com.example.library.entity.Loan;
import com.example.library.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {
    public final LoanRepository loanRepository;
    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }
    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    public Loan getLoanById(Long id) {
        return loanRepository.findById(id).orElse(null);
    }

    public Loan saveLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    public void deleteLoan(Long id) {
        loanRepository.deleteById(id);
    }

    public List<Loan> getLoansByUser(Long userId) {
        return loanRepository.findByUser(userId);
    }

    public List<Loan> getLoansByBook(Long bookId) {
        return loanRepository.findByBook(bookId);
    }
}