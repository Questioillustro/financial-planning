package com.brewster.financialplanning.repository;

import com.brewster.financialplanning.data.FinanceEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinanceRepository extends CrudRepository<FinanceEntity, Long> {
    List<FinanceEntity> findAllByFinanceType(String financeType);
}
