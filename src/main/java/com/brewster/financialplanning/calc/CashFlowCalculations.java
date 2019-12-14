package com.brewster.financialplanning.calc;

import com.brewster.financialplanning.data.FinanceEntity;
import com.brewster.financialplanning.data.Finances;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CashFlowCalculations {

    public void setAggregates(Finances finances) {
        finances.setTotalIncome( calculateAnnualTotal( finances.getIncome() ) );
        finances.setMonthlyIncome( Math.round( finances.getTotalIncome() / 12 ) );

        finances.setTotalBudget( - calculateAnnualTotal( finances.getBudget() ) );
        finances.setMonthlyBudget( Math.round( finances.getTotalBudget() / 12 ) );

        finances.setTotalBills( - calculateAnnualTotal( finances.getBills() ) );
        finances.setMonthlyBills( Math.round( finances.getTotalBills() / 12 ) );

        finances.setMonthlyDelta( finances.getMonthlyIncome() + finances.getMonthlyBills() + finances.getMonthlyBudget() );

        finances.getAccounts().forEach((a) -> finances.setTotalAccountsValue( finances.getTotalAccountsValue() + a.getBalance()));
        finances.getLoans().forEach((a) -> finances.setTotalDebt( finances.getTotalDebt() - a.getBalance()));
    }

    private double calculateAnnualTotal(List<FinanceEntity> finances) {
        double total = 0.0;
        for (FinanceEntity finance : finances ) {
            total += getAnnualValue( finance );
        }
        return total;
    }

    private double getAnnualValue(FinanceEntity finance) {
        switch (finance.getAccrualFrequency()) {
            case "MONTHLY":
                return finance.getAccrualAmount() * 12;
            case "ANNUALLY":
                return finance.getAccrualAmount();
            case "WEEKLY":
                return finance.getAccrualAmount() * 52;
            case "BI-WEEKLY":
                return finance.getAccrualAmount() * 26;
            case "QUARTERLY":
                return finance.getAccrualAmount() * 4;
            default:
                return 0.0;
        }
    }
}
