package com.brewster.financialplanning.repository;

import com.brewster.financialplanning.data.AccountEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<AccountEntity, Long> {

    Iterable<AccountEntity> findAccountEntitiesByType(String type);
}
