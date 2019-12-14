package com.brewster.financialplanning.repository;

import com.brewster.financialplanning.data.FinanceEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinanceRepository extends CrudRepository<FinanceEntity, Long> {
    Iterable<FinanceEntity> findAllByFinanceType(String financeType);
}
