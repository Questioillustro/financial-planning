package com.brewster.financialplanning.service;

import com.brewster.financialplanning.data.IncomeEntity;
import com.brewster.financialplanning.repository.IncomeRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class IncomeService {

    private final IncomeRepository incomeRepository;

    public IncomeService(final IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    public Iterable<IncomeEntity> getIncome() {
        return incomeRepository.findAll();
    }

    @Transactional
    public IncomeEntity save(IncomeEntity incomeEntity) {
        return incomeRepository.save(incomeEntity);
    }
}
