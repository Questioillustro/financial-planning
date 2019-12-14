package com.brewster.financialplanning.bootstrap;

import com.brewster.financialplanning.data.AccountEntity;
import com.brewster.financialplanning.data.CashFlowEntity;

import com.brewster.financialplanning.service.AccountService;
import com.brewster.financialplanning.service.CashFlowService;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class BootstrapData {

    private final CashFlowService cashFlowService;
    private final AccountService accountService;

    public BootstrapData(final CashFlowService cashFlowService,
                         final AccountService accountService) {
        this.cashFlowService = cashFlowService;
        this.accountService = accountService;
    }

    @PostConstruct
    public void generateBaseline() {
        createIncome();
        createExpenses();
        createBudget();
        createLoans();
        createAccounts();
    }

    private void createAccounts() {
        AccountEntity account = new AccountEntity();
        account.setLabel("Checking");
        account.setDollarAmount(1000L);
        account.setApr(0.0);
        account.setType("CREDIT");

        accountService.save(account);

        AccountEntity account2 = new AccountEntity();
        account2.setLabel("Savings");
        account2.setDollarAmount(15000L);
        account2.setApr(1.7);
        account2.setType("CREDIT");

        accountService.save(account2);

        AccountEntity account3 = new AccountEntity();
        account3.setLabel("HSA");
        account3.setDollarAmount(1000L);
        account3.setApr(0.0);
        account3.setType("CREDIT");

        accountService.save(account3);

        AccountEntity account4 = new AccountEntity();
        account4.setLabel("401K");
        account4.setDollarAmount(2600L);
        account4.setApr(4.0);
        account4.setType("CREDIT");

        accountService.save(account4);

        AccountEntity account5 = new AccountEntity();
        account5.setLabel("Equities");
        account5.setDollarAmount(11500L);
        account5.setApr(6.0);
        account5.setType("CREDIT");

        accountService.save(account5);
    }

    private void createBudget() {
        CashFlowEntity budget = new CashFlowEntity();
        budget.setLabel("Gas");
        budget.setDollarAmount(100L);
        budget.setDebitType("BUDGET");
        budget.setFlowType("DEBIT");

        cashFlowService.save(budget);

        CashFlowEntity budget2 = new CashFlowEntity();
        budget2.setLabel("Food");
        budget2.setDollarAmount(300L);
        budget2.setDebitType("BUDGET");
        budget2.setFlowType("DEBIT");

        cashFlowService.save(budget2);

        CashFlowEntity budget3 = new CashFlowEntity();
        budget3.setLabel("Cats");
        budget3.setDollarAmount(60L);
        budget3.setDebitType("BUDGET");
        budget3.setFlowType("DEBIT");

        cashFlowService.save(budget3);

        CashFlowEntity budget4 = new CashFlowEntity();
        budget4.setLabel("Alcohol");
        budget4.setDollarAmount(80L);
        budget4.setDebitType("BUDGET");
        budget4.setFlowType("DEBIT");

        cashFlowService.save(budget4);

        CashFlowEntity budget5 = new CashFlowEntity();
        budget5.setLabel("Lunches");
        budget5.setDollarAmount(133L);
        budget5.setDebitType("BUDGET");
        budget5.setFlowType("DEBIT");

        cashFlowService.save(budget5);

        CashFlowEntity budget6 = new CashFlowEntity();
        budget6.setLabel("Cigarettes");
        budget6.setDollarAmount(200L);
        budget6.setDebitType("BUDGET");
        budget6.setFlowType("DEBIT");

        cashFlowService.save(budget6);
    }

    private void createLoans() {
        AccountEntity loan = new AccountEntity();
        loan.setDollarAmount(49000L);
        loan.setApr(5.0);
        loan.setLabel("Student Loan");
        loan.setType("DEBIT");

        accountService.save(loan);

        AccountEntity loan2 = new AccountEntity();
        loan2.setDollarAmount(147000L);
        loan2.setApr(3.25);
        loan2.setLabel("Mortgage");
        loan2.setType("DEBIT");

        accountService.save(loan2);
    }

    private void createExpenses() {
        CashFlowEntity bill = new CashFlowEntity();
        bill.setLabel("Housing");
        bill.setDollarAmount(1765L);
        bill.setDebitType("BILL");
        bill.setFlowType("DEBIT");

        cashFlowService.save(bill);

        CashFlowEntity bill2 = new CashFlowEntity();
        bill2.setLabel("Car Insurance");
        bill2.setDollarAmount(105L);
        bill2.setDebitType("BILL");
        bill2.setFlowType("DEBIT");

        cashFlowService.save(bill2);

        CashFlowEntity bill3 = new CashFlowEntity();
        bill3.setLabel("Phone");
        bill3.setDollarAmount(85L);
        bill3.setDebitType("BILL");
        bill3.setFlowType("DEBIT");

        cashFlowService.save(bill3);

        CashFlowEntity bill4 = new CashFlowEntity();
        bill4.setLabel("Utilities");
        bill4.setDollarAmount(225L);
        bill4.setDebitType("BILL");
        bill4.setFlowType("DEBIT");

        cashFlowService.save(bill4);

        CashFlowEntity bill5 = new CashFlowEntity();
        bill5.setLabel("Student Loan");
        bill5.setDollarAmount(665L);
        bill5.setDebitType("BILL");
        bill5.setFlowType("DEBIT");

        cashFlowService.save(bill5);

        CashFlowEntity bill6 = new CashFlowEntity();
        bill6.setLabel("Streaming Services");
        bill6.setDollarAmount(52L);
        bill6.setDebitType("BILL");
        bill6.setFlowType("DEBIT");

        cashFlowService.save(bill6);
    }

    private void createIncome() {
        CashFlowEntity cashFlowEntity = new CashFlowEntity();
        cashFlowEntity.setDollarAmount(62270L);
        cashFlowEntity.setLabel("Salary");
        cashFlowEntity.setFlowType("CREDIT");

        cashFlowService.save(cashFlowEntity);

        CashFlowEntity cashFlowEntity2 = new CashFlowEntity();
        cashFlowEntity2.setDollarAmount(8400L);
        cashFlowEntity2.setLabel("Rent");
        cashFlowEntity2.setFlowType("CREDIT");

        cashFlowService.save(cashFlowEntity2);
    }
}
