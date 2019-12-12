package com.brewster.financialplanning.service;

import com.brewster.financialplanning.data.LoanEntity;
import com.brewster.financialplanning.repository.LoanRepository;
import org.springframework.stereotype.Service;

@Service
public class LoanService {

    private final LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public Iterable<LoanEntity> getLoans() {
        return loanRepository.findAll();
    }

    public void saveLoan(LoanEntity loanEntity) {
        loanRepository.save(loanEntity);
    }

    public void saveLoans(Iterable<LoanEntity> loanEntities) {
        loanRepository.saveAll(loanEntities);
    }
}
