package com.brewster.financialplanning.data;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Finances {
    private Iterable<FinanceEntity> bills;
    private Iterable<FinanceEntity> budget;
    private Iterable<FinanceEntity> income;

    private Double totalBills = 0.0;
    private Double totalBudget = 0.0;
    private Double totalIncome = 0.0;

    private Double monthlyIncome = 0.0;
    private Double monthlyDelta = 0.0;

    private Iterable<FinanceEntity> accounts;
    private Iterable<FinanceEntity> loans;

    private Double totalAccountsValue = 0.0;
    private Double totalDebt = 0.0;

    public void setBills(Iterable<FinanceEntity> bills) {
        this.bills = bills;

        totalBills = 0.0;
        bills.forEach((b) -> totalBills -= b.getAccrualAmount());
        this.monthlyDelta += totalBills;
    }

    public void setBudget(Iterable<FinanceEntity> budget) {
        this.budget = budget;

        totalBudget = 0.0;
        budget.forEach((b) -> totalBudget -= b.getAccrualAmount());
        this.monthlyDelta += totalBudget;
    }

    public void setIncome(Iterable<FinanceEntity> income) {
        this.income = income;

        totalIncome = 0.0;
        income.forEach((i) -> totalIncome += i.getAccrualAmount());
        this.monthlyIncome += Math.round(totalIncome/12);
        this.monthlyDelta += Math.round(totalIncome/12);
    }

    public void setAccounts(Iterable<FinanceEntity> accounts) {
        this.accounts = accounts;

        totalAccountsValue = 0.0;
        this.accounts.forEach((a) -> {
            totalAccountsValue += a.getBalance();
        });
    }

    public void setLoans(Iterable<FinanceEntity> loans) {
        this.loans = loans;

        totalDebt = 0.0;
        this.loans.forEach((l) -> {
            totalDebt += l.getBalance();
        });
    }
}
