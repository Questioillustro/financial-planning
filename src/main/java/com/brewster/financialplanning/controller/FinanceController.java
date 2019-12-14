package com.brewster.financialplanning.controller;

import com.brewster.financialplanning.data.*;
import com.brewster.financialplanning.service.FinanceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brewster/finance")
@CrossOrigin("http://localhost:4200")
public class FinanceController {

    private final FinanceService financeService;

    public FinanceController(final FinanceService financeService) {
        this.financeService = financeService;
    }

    @GetMapping
    public Finances getFinances() {
        return financeService.getFinances();
    }

    @PutMapping
    public void saveFinances(@RequestBody List<FinanceEntity> financeEntities) {
        financeService.saveAll(financeEntities);
    }

    @DeleteMapping("/{id}")
    public void deleteFinance(@PathVariable Long id) {
        financeService.delete(id);
    }
}
