package com.brewster.financialplanning.controller;

import com.brewster.financialplanning.data.AmortizationSchedule;
import com.brewster.financialplanning.service.AmortizationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/brewster/amortization")
@CrossOrigin("http://localhost:4200")
public class AmortizationController {

    private final AmortizationService amortizationService;

    public AmortizationController(final AmortizationService amortizationService) {
        this.amortizationService = amortizationService;
    }

    @GetMapping("/{id}")
    public AmortizationSchedule getAmortizationSchedule(@PathVariable Long id) {
        return amortizationService.getAmortizationSchedule(id);
    }
}
