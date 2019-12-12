package com.brewster.financialplanning.controller;

import com.brewster.financialplanning.data.IncomeEntity;
import com.brewster.financialplanning.service.IncomeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brewster/finance")
@CrossOrigin("http://localhost:4200")
public class FinanceController {

    private final IncomeService incomeService;

    public FinanceController(final IncomeService incomeService) {
        this.incomeService = incomeService;
    }

    @GetMapping("/income")
    public Iterable<IncomeEntity> getIncome() {
        return incomeService.getIncome();
    }

    @PutMapping("/income")
    public void setIncome(@RequestBody List<IncomeEntity> incomeSources) {
        incomeService.saveAll(incomeSources);
    }
}
