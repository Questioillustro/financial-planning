package com.brewster.financialplanning.repository;

import com.brewster.financialplanning.data.IncomeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeRepository extends CrudRepository<IncomeEntity, Long> {
}
