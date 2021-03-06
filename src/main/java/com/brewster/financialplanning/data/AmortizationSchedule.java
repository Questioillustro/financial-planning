package com.brewster.financialplanning.data;

import com.brewster.financialplanning.calc.AmortizationCalculations;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class AmortizationSchedule {
    private FinanceEntity loan;
    private List<AmortizationCalculations.SnapShot> snapshots;
    private String payoffDate;
    private double interestPaid;
}
