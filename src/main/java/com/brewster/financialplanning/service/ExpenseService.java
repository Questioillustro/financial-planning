package com.brewster.financialplanning.service;

import com.brewster.financialplanning.data.ExpenseEntity;
import com.brewster.financialplanning.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(final ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public Iterable<ExpenseEntity> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public void save(ExpenseEntity expenseEntity) {
        expenseRepository.save(expenseEntity);
    }

    public void saveAll(Iterable<ExpenseEntity> expenseEntities) {
        expenseRepository.saveAll(expenseEntities);
    }
}
