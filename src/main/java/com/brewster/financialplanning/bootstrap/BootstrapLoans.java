package com.brewster.financialplanning.bootstrap;

import com.brewster.financialplanning.data.FinanceEntity;
import com.brewster.financialplanning.service.FinanceService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class BootstrapLoans {

    private String FINANCE_TYPE = "LOAN";
    private String ACCRUAL_TYPE = "PERCENT";
    private String ACCRUAL_FREQUENCY = "ANNUALLY";

    private final FinanceService financeService;

    public BootstrapLoans(FinanceService financeService) {
        this.financeService = financeService;
    }

    @PostConstruct
    public void generateData() {
        List<FinanceEntity> loans = new ArrayList<>();

        FinanceEntity loan = new FinanceEntity();
        loan.setLabel("Student Loans");
        loan.setBalance(49000.0);
        loan.setAccrualAmount(5.0);
        loan.setPayment(665.0);
        loans.add(loan);

        FinanceEntity loan2 = new FinanceEntity();
        loan2.setLabel("Mortgage");
        loan2.setBalance(147000.0);
        loan2.setAccrualAmount(3.25);
        loan2.setPayment(1080.0);
        loans.add(loan2);

        loans.forEach((i) -> {
            i.setFinanceType(FINANCE_TYPE);
            i.setAccrualType(ACCRUAL_TYPE);
            i.setAccrualFrequency(ACCRUAL_FREQUENCY);
        });

        financeService.saveAll(loans);
    }
}
