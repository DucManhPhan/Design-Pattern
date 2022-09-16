package com.manh.cashflow.core.service.impl;

import com.manh.cashflow.core.service.IncomeServicePort;
import com.manh.cashflow.database.entity.Income;
import com.manh.cashflow.database.repository.IncomeRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeServiceImpl implements IncomeServicePort {

    @Autowired
    private IncomeRepositoryPort incomeRepositoryPort;

    @Override
    public List<Income> getAll() {
        return this.incomeRepositoryPort.findAll();
    }

    @Override
    public Income get(Long id) {
        return this.incomeRepositoryPort.findById(id).orElse(null);
    }

    @Override
    public Income create(Income entity) {
        return this.incomeRepositoryPort.save(entity);
    }

    @Override
    public Income save(Income entity) {
        return this.incomeRepositoryPort.save(entity);
    }

    @Override
    public void delete(Long id) {
        this.incomeRepositoryPort.deleteById(id);
    }
}
