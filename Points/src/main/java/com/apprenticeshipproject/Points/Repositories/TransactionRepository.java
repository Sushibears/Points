package com.apprenticeshipproject.Points.Repositories;

import com.apprenticeshipproject.Points.Entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}