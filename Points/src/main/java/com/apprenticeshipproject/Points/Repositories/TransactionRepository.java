package com.apprenticeshipproject.Points.Repositories;

import com.apprenticeshipproject.Points.Entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    List<Transaction> findByPayer(String payer);
    Transaction findByPayerAndTimestamp(String payer,Timestamp timestamp);
}