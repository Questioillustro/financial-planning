package com.brewster.financialplanning.calc;

import com.brewster.financialplanning.data.Finances;
import org.springframework.stereotype.Component;

@Component
public class CashFlowCalculations {

    public void setAggregates(Finances finances) {
        setIncome(finances);
    }

    public void setIncome(Finances finances) {
        finances.getIncome().forEach((i) -> {
            switch (i.getAccrualFrequency()) {
                case "MONTHLY":
                    finances.setTotalIncome( finances.getTotalIncome() + i.getAccrualAmount()*12 );
                    break;
                case "ANNUALLY":
                    finances.setTotalIncome( finances.getTotalIncome() + i.getAccrualAmount() );
                    break;
                case "WEEKLY":
                    finances.setTotalIncome( finances.getTotalIncome() + i.getAccrualAmount()*52 );
                    break;
            }
        });

        finances.setMonthlyIncome( Math.round(finances.getTotalIncome() / 12) );
        finances.setMonthlyDelta( finances.getMonthlyIncome() + finances.getTotalBills() + finances.getTotalBudget());
    }
}
