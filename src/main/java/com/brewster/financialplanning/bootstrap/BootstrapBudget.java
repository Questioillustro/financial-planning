package com.brewster.financialplanning.bootstrap;

import com.brewster.financialplanning.data.FinanceEntity;
import com.brewster.financialplanning.service.FinanceService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class BootstrapBudget {

    private String FINANCE_TYPE = "BUDGET";
    private String ACCRUAL_TYPE = "FLAT";

    private final FinanceService financeService;

    public BootstrapBudget(FinanceService financeService) {
        this.financeService = financeService;
    }

    @PostConstruct
    public void generateData() {
        List<FinanceEntity> budget = new ArrayList<>();

        FinanceEntity finance = new FinanceEntity();
        finance.setLabel("Gas");
        finance.setAccrualAmount(100.0);
        budget.add(finance);

        FinanceEntity finance2 = new FinanceEntity();
        finance2.setLabel("Food");
        finance2.setAccrualAmount(300.0);
        budget.add(finance2);

        FinanceEntity finance3 = new FinanceEntity();
        finance3.setLabel("Cats");
        finance3.setAccrualAmount(60.0);
        budget.add(finance3);

        FinanceEntity finance4 = new FinanceEntity();
        finance4.setLabel("Alcohol");
        finance4.setAccrualAmount(80.0);
        budget.add(finance4);

        FinanceEntity finance5 = new FinanceEntity();
        finance5.setLabel("Lunches");
        finance5.setAccrualAmount(133.0);
        budget.add(finance5);

        FinanceEntity finance6 = new FinanceEntity();
        finance6.setLabel("Cigarettes");
        finance6.setAccrualAmount(200.0);
        budget.add(finance6);

        budget.forEach((i) -> {
            i.setFinanceType(FINANCE_TYPE);
            i.setAccrualType(ACCRUAL_TYPE);
        });

        financeService.saveAll(budget);
    }
}
