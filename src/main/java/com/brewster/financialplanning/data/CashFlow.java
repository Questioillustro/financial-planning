package com.brewster.financialplanning.data;

import lombok.Data;

@Data
public class CashFlow {
    private Iterable<CashFlowEntity> bills;
    private Iterable<CashFlowEntity> budget;
    private Iterable<CashFlowEntity> income;

    private Long totalBills;
    private Long totalBudget;
    private Long totalIncome;

    private Long monthlyIncome = 0L;
    private Long monthlyDelta = 0L;

    public void setBills(Iterable<CashFlowEntity> bills) {
        this.bills = bills;

        totalBills = 0L;
        bills.forEach((b) -> totalBills += b.getDollarAmount());
        this.monthlyDelta -= totalBills;
    }

    public void setBudget(Iterable<CashFlowEntity> budget) {
        this.budget = budget;

        totalBudget = 0L;
        budget.forEach((b) -> totalBudget += b.getDollarAmount());
        this.monthlyDelta -= totalBudget;
    }

    public void setIncome(Iterable<CashFlowEntity> income) {
        this.income = income;

        totalIncome = 0L;
        income.forEach((i) -> totalIncome += i.getDollarAmount());
        this.monthlyIncome += totalIncome/12;
        this.monthlyDelta += totalIncome/12;
    }
}
