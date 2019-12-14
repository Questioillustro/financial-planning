package com.brewster.financialplanning.controller;

import com.brewster.financialplanning.data.*;
import com.brewster.financialplanning.service.AccountService;
import com.brewster.financialplanning.service.CashFlowService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brewster/finance")
@CrossOrigin("http://localhost:4200")
public class FinanceController {

    private final CashFlowService cashFlowService;
    private final AccountService accountService;

    public FinanceController(final CashFlowService cashFlowService,
                             final AccountService accountService) {
        this.cashFlowService = cashFlowService;
        this.accountService = accountService;
    }

    @GetMapping("/cashflow")
    public CashFlow getCashFlow() {
        return cashFlowService.getCashFlow();
    }

    @PutMapping("/cashflow")
    public void saveCashFlow(@RequestBody List<CashFlowEntity> cashFlowEntities) {
        cashFlowService.saveAll(cashFlowEntities);
    }

    @DeleteMapping("/cashflow/{id}")
    public void deleteCashFlow(@PathVariable Long id) {
        cashFlowService.delete(id);
    }

    @GetMapping("/account")
    public Accounts getAccounts() {
        return accountService.getAccounts();
    }

    @PutMapping("/account")
    public void saveAccounts(@RequestBody Iterable<AccountEntity> accounts) {
        accountService.saveAccounts(accounts);
    }

    @DeleteMapping("/account")
    public void deleteAccount(@RequestBody AccountEntity account) {
        accountService.deleteAccount(account);
    }
}
