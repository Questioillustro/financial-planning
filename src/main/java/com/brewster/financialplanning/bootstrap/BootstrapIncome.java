package com.brewster.financialplanning.bootstrap;

import com.brewster.financialplanning.data.IncomeEntity;
import com.brewster.financialplanning.service.IncomeService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class BootstrapIncome {

    private final IncomeService incomeService;

    public BootstrapIncome(final IncomeService incomeService) {
        this.incomeService = incomeService;
    }

    @PostConstruct
    public void generateBaseline() {
        IncomeEntity incomeEntity = new IncomeEntity();
        incomeEntity.setDollarAmount(91500L);
        incomeEntity.setLabel("Salary");

        incomeService.save(incomeEntity);

        IncomeEntity incomeEntity2 = new IncomeEntity();
        incomeEntity2.setDollarAmount(8400L);
        incomeEntity2.setLabel("Rent");

        incomeService.save(incomeEntity2);
    }
}
