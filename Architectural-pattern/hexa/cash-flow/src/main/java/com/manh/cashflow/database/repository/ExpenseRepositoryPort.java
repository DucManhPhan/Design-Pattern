package com.manh.cashflow.database.repository;

import com.manh.cashflow.database.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepositoryPort extends JpaRepository<Expense, Long> {
}
