package com.brewster.financialplanning.bootstrap;

import com.brewster.financialplanning.data.FinanceEntity;
import com.brewster.financialplanning.service.FinanceService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class BootstrapIncome {

    private String FINANCE_TYPE = "INCOME";
    private String ACCRUAL_TYPE = "FLAT";
    private String ACCRUAL_FREQUENCY = "ANNUALLY";

    private final FinanceService financeService;

    public BootstrapIncome(FinanceService financeService) {
        this.financeService = financeService;
    }

    @PostConstruct
    public void generateData() {
        List<FinanceEntity> income = new ArrayList<>();

        FinanceEntity financeEntity = new FinanceEntity();
        financeEntity.setAccrualAmount(62270.0);
        financeEntity.setLabel("Salary");
        income.add(financeEntity);

        FinanceEntity financeEntity1 = new FinanceEntity();
        financeEntity1.setAccrualAmount(8400.0);
        financeEntity1.setLabel("Rent");
        income.add(financeEntity1);

        income.forEach((i) -> {
            i.setFinanceType(FINANCE_TYPE);
            i.setAccrualType(ACCRUAL_TYPE);
            i.setAccrualFrequency(ACCRUAL_FREQUENCY);
        });

        financeService.saveAll(income);
    }
}
