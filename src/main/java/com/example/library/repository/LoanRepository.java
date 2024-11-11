package com.example.library.repository;

import com.example.library.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
    List<Loan> findByUser(Long userId);
    List<Loan> findByBook(Long bookId);
}