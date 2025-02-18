package com.manh.cashflow.core.service.impl;

import com.manh.cashflow.core.service.ExpenseServicePort;
import com.manh.cashflow.database.entity.Expense;
import com.manh.cashflow.database.repository.ExpenseRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseServicePort {

    @Autowired
    private ExpenseRepositoryPort repository;

    @Override
    public List<Expense> getAll() {
        return repository.findAll();
    }

    @Override
    public Expense get(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Expense create(Expense entity) {
        return repository.save(entity);
    }

    @Override
    public Expense save(Expense entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}

