package com.brewster.financialplanning.service;

import com.brewster.financialplanning.calc.CashFlowCalculations;
import com.brewster.financialplanning.data.FinanceEntity;
import com.brewster.financialplanning.data.Finances;
import com.brewster.financialplanning.repository.FinanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinanceService {
    private final FinanceRepository financeRepository;
    private final CashFlowCalculations cashFlowCalculations;

    public FinanceService(final FinanceRepository financeRepository,
                          final CashFlowCalculations cashFlowCalculations) {
        this.financeRepository = financeRepository;
        this.cashFlowCalculations = cashFlowCalculations;
    }

    public Finances getFinances() {
        Finances finances = new Finances();
        List<FinanceEntity> bills = financeRepository.findAllByFinanceType("BILL");
        finances.setBills(bills);

        List<FinanceEntity> budget = financeRepository.findAllByFinanceType("BUDGET");
        finances.setBudget(budget);

        List<FinanceEntity> income = financeRepository.findAllByFinanceType("INCOME");
        finances.setIncome(income);

        List<FinanceEntity> accounts = financeRepository.findAllByFinanceType("ACCOUNT");
        finances.setAccounts(accounts);

        List<FinanceEntity> loans = financeRepository.findAllByFinanceType("LOAN");
        finances.setLoans(loans);

        cashFlowCalculations.setAggregates(finances);
        return finances;
    }

    public void save(FinanceEntity financeEntity) {
        financeRepository.save(financeEntity);
    }

    public void saveAll(Iterable<FinanceEntity> financeEntities) {
        financeRepository.saveAll(financeEntities);
    }

    public void delete(Long id) {
        financeRepository.deleteById(id);
    }

}
