package com.brewster.financialplanning.service;

import com.brewster.financialplanning.data.CashFlowEntity;
import com.brewster.financialplanning.data.CashFlow;
import com.brewster.financialplanning.repository.CashFlowRepository;
import org.springframework.stereotype.Service;

@Service
public class CashFlowService {

    private final CashFlowRepository cashFlowRepository;

    public CashFlowService(CashFlowRepository cashFlowRepository) {
        this.cashFlowRepository = cashFlowRepository;
    }

    public CashFlow getCashFlow() {
        CashFlow cashFlow = new CashFlow();
        Iterable<CashFlowEntity> bills = cashFlowRepository.findAllByDebitType("BILL");
        cashFlow.setBills(bills);

        Iterable<CashFlowEntity> budget = cashFlowRepository.findAllByDebitType("BUDGET");
        cashFlow.setBudget(budget);

        Iterable<CashFlowEntity> income = cashFlowRepository.findAllByFlowType("CREDIT");
        cashFlow.setIncome(income);
        return cashFlow;
    }

    public void save(CashFlowEntity cashFlowEntity) {
        cashFlowRepository.save(cashFlowEntity);
    }

    public void saveAll(Iterable<CashFlowEntity> cashFlowEntities) {
        cashFlowRepository.saveAll(cashFlowEntities);
    }

    public void delete(Long id) {
        cashFlowRepository.deleteById(id);
    }
}
