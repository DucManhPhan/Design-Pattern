package com.manh.cashflow.database.repository;

import com.manh.cashflow.database.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeRepositoryPort extends JpaRepository<Income, Long> {
}
