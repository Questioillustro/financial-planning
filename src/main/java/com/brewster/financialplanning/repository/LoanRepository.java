package com.brewster.financialplanning.repository;

import com.brewster.financialplanning.data.LoanEntity;
import org.springframework.data.repository.CrudRepository;

public interface LoanRepository extends CrudRepository<LoanEntity, Long> {
}
