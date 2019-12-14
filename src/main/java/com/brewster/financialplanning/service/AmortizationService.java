package com.brewster.financialplanning.service;

import com.brewster.financialplanning.calc.AmortizationCalculations;
import com.brewster.financialplanning.data.AmortizationSchedule;
import com.brewster.financialplanning.data.FinanceEntity;
import com.brewster.financialplanning.repository.FinanceRepository;
import org.springframework.stereotype.Service;

@Service
public class AmortizationService {

    private final FinanceRepository financeRepository;
    private final AmortizationCalculations amortizationCalculations;

    public AmortizationService(final FinanceRepository financeRepository,
                               final AmortizationCalculations amortizationCalculations) {
        this.financeRepository = financeRepository;
        this.amortizationCalculations = amortizationCalculations;
    }

    public AmortizationSchedule getAmortizationSchedule(Long financeEntityId) {
        FinanceEntity loan = financeRepository.findById(financeEntityId).get();
        return amortizationCalculations.getAmortization(loan);
    }
}
