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
        incomeEntity.setSalary(1000L);
        incomeService.save(incomeEntity);
    }
}
