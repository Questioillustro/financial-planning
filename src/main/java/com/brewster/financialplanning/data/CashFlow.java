package com.brewster.financialplanning.data;

import lombok.Data;

@Data
public class Expenses {
    private Iterable<ExpenseEntity> bills;
    private Iterable<ExpenseEntity> budget;

    private Long totalBills;
    private Long totalBudget;

    public void setBills(Iterable<ExpenseEntity> bills) {
        this.bills = bills;

        totalBills = 0L;
        bills.forEach((b) -> totalBills += b.getDollarAmount());
    }

    public void setBudget(Iterable<ExpenseEntity> budget) {
        this.budget = budget;

        totalBudget = 0L;
        budget.forEach((b) -> totalBudget += b.getDollarAmount());
    }
}
