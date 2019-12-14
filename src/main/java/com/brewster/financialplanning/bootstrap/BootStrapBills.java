package com.brewster.financialplanning.bootstrap;

import com.brewster.financialplanning.data.FinanceEntity;
import com.brewster.financialplanning.service.FinanceService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class BootStrapBills {

    private String FINANCE_TYPE = "BILL";
    private String ACCRUAL_TYPE = "FLAT";
    private String ACCRUAL_FREQUENCY = "MONTHLY";

    private final FinanceService financeService;

    public BootStrapBills(FinanceService financeService) {
        this.financeService = financeService;
    }

    @PostConstruct
    public void generateData() {
        List<FinanceEntity> bills = new ArrayList<>();
        
        FinanceEntity bill = new FinanceEntity();
        bill.setLabel("Housing");
        bill.setAccrualAmount(1765.0);
        bills.add(bill);

        FinanceEntity bill2 = new FinanceEntity();
        bill2.setLabel("Car Insurance");
        bill2.setAccrualAmount(105.0);
        bills.add(bill2);

        FinanceEntity bill3 = new FinanceEntity();
        bill3.setLabel("Phone");
        bill3.setAccrualAmount(85.0);
        bills.add(bill3);

        FinanceEntity bill4 = new FinanceEntity();
        bill4.setLabel("Utilities");
        bill4.setAccrualAmount(225.0);
        bills.add(bill4);

        FinanceEntity bill5 = new FinanceEntity();
        bill5.setLabel("Student Loan");
        bill5.setAccrualAmount(665.0);
        bills.add(bill5);

        FinanceEntity bill6 = new FinanceEntity();
        bill6.setLabel("Streaming Services");
        bill6.setAccrualAmount(52.0);
        bills.add(bill6);

        bills.forEach((i) -> {
            i.setFinanceType(FINANCE_TYPE);
            i.setAccrualType(ACCRUAL_TYPE);
            i.setAccrualFrequency(ACCRUAL_FREQUENCY);
        });

        financeService.saveAll(bills);
    }
}
