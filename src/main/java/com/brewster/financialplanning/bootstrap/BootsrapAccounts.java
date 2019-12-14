package com.brewster.financialplanning.bootstrap;

import com.brewster.financialplanning.data.FinanceEntity;
import com.brewster.financialplanning.service.FinanceService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class BootsrapAccounts {

    private String FINANCE_TYPE = "ACCOUNT";
    private String ACCRUAL_TYPE = "PERCENT";
    private String ACCRUAL_FREQUENCY = "ANNUALLY";

    private final FinanceService financeService;

    public BootsrapAccounts(FinanceService financeService) {
        this.financeService = financeService;
    }

    @PostConstruct
    public void generateData() {
        List<FinanceEntity> accounts = new ArrayList<>();

        FinanceEntity account = new FinanceEntity();
        account.setLabel("Checking");
        account.setBalance(1000.0);
        account.setAccrualAmount(0.0);
        accounts.add(account);

        FinanceEntity account2 = new FinanceEntity();
        account2.setLabel("Savings");
        account2.setBalance(15000.0);
        account2.setAccrualAmount(1.7);
        accounts.add(account2);

        FinanceEntity account3 = new FinanceEntity();
        account3.setLabel("HSA");
        account3.setBalance(1000.0);
        account3.setAccrualAmount(0.0);
        accounts.add(account3);

        FinanceEntity account4 = new FinanceEntity();
        account4.setLabel("401K");
        account4.setBalance(2600.0);
        account4.setAccrualAmount(4.0);
        accounts.add(account4);

        FinanceEntity account5 = new FinanceEntity();
        account5.setLabel("Equities");
        account5.setBalance(11500.0);
        account5.setAccrualAmount(6.0);
        accounts.add(account5);

        accounts.forEach((i) -> {
            i.setFinanceType(FINANCE_TYPE);
            i.setAccrualType(ACCRUAL_TYPE);
            i.setAccrualFrequency(ACCRUAL_FREQUENCY);
        });

        financeService.saveAll(accounts);
    }
}
