package com.brewster.financialplanning.data;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Finances {
    private List<FinanceEntity> bills;
    private List<FinanceEntity> budget;
    private List<FinanceEntity> income;

    private double totalBills = 0.0;
    private double monthlyBills = 0.0;

    private double totalBudget = 0.0;
    private double monthlyBudget = 0.0;

    private double totalIncome = 0.0;
    private double monthlyIncome = 0.0;

    private double monthlyDelta = 0.0;

    private List<FinanceEntity> accounts;
    private List<FinanceEntity> loans;

    private double totalAccountsValue = 0.0;
    private double totalDebt = 0.0;
}
