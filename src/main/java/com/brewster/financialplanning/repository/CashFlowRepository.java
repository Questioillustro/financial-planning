package com.brewster.financialplanning.repository;

import com.brewster.financialplanning.data.CashFlowEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashFlowRepository extends CrudRepository<CashFlowEntity, Long> {
    Iterable<CashFlowEntity> findAllByDebitType(String debitType);
    Iterable<CashFlowEntity> findAllByFlowType(String flowType);
}
