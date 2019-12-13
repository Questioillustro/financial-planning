package com.brewster.financialplanning.service;

import com.brewster.financialplanning.data.ExpenseEntity;
import com.brewster.financialplanning.data.Expenses;
import com.brewster.financialplanning.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(final ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public Expenses getExpenses() {
        Expenses expenses = new Expenses();
        Iterable<ExpenseEntity> bills = expenseRepository.findAllByType("BILL");
        expenses.setBills(bills);

        Iterable<ExpenseEntity> budget = expenseRepository.findAllByType("BUDGET");
        expenses.setBudget(budget);
        return expenses;
    }

    public void save(ExpenseEntity expenseEntity) {
        expenseRepository.save(expenseEntity);
    }

    public void saveAll(Iterable<ExpenseEntity> expenseEntities) {
        expenseRepository.saveAll(expenseEntities);
    }
}
