package com.apprenticeshipproject.Points.Repositories;

import com.apprenticeshipproject.Points.Entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    List<Transaction> findByPayer(String payer);
    List<Transaction> findAllByOrderByTimestampDesc();

    @Transactional
    Transaction findByPayerAndTimestamp(String payer, LocalDate timestamp);
}