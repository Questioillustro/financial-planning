package com.brewster.financialplanning.controller;

import com.brewster.financialplanning.data.ExpenseEntity;
import com.brewster.financialplanning.data.IncomeEntity;
import com.brewster.financialplanning.data.LoanEntity;
import com.brewster.financialplanning.service.ExpenseService;
import com.brewster.financialplanning.service.IncomeService;
import com.brewster.financialplanning.service.LoanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brewster/finance")
@CrossOrigin("http://localhost:4200")
public class FinanceController {

    private final IncomeService incomeService;
    private final ExpenseService expenseService;
    private final LoanService loanService;

    public FinanceController(final IncomeService incomeService,
                             final ExpenseService expenseService,
                             final LoanService loanService) {
        this.incomeService = incomeService;
        this.expenseService = expenseService;
        this.loanService = loanService;
    }

    @GetMapping("/income")
    public Iterable<IncomeEntity> getIncome() {
        return incomeService.getIncomeSources();
    }

    @PutMapping("/income")
    public void saveIncomeSources(@RequestBody List<IncomeEntity> incomeSources) {
        incomeService.saveAll(incomeSources);
    }

    @GetMapping("/expense")
    public Iterable<ExpenseEntity> getExpenses() {
        return expenseService.getAllExpenses();
    }

    @PutMapping("/expense")
    public void saveExpenses(@RequestBody List<ExpenseEntity> expenseEntities) {
        expenseService.saveAll(expenseEntities);
    }

    @GetMapping("/loan")
    public Iterable<LoanEntity> getLoans() {
        return loanService.getLoans();
    }

    @PutMapping("/loan")
    public void saveLoans(@RequestBody List<LoanEntity> loans) {
        loanService.saveLoans(loans);
    }
}
