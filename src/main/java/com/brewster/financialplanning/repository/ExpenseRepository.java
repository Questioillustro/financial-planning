package com.brewster.financialplanning.repository;

import com.brewster.financialplanning.data.ExpenseEntity;
import org.springframework.data.repository.CrudRepository;

public interface ExpenseRepository extends CrudRepository<ExpenseEntity, Long> {
    Iterable<ExpenseEntity> findAllByType(String type);
}
