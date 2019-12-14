package com.brewster.financialplanning.service;

import com.brewster.financialplanning.data.AccountEntity;
import com.brewster.financialplanning.data.Accounts;
import com.brewster.financialplanning.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(final AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Accounts getAccounts() {
        Accounts accounts = new Accounts();

        Iterable<AccountEntity> accountList = accountRepository.findAccountEntitiesByType("CREDIT");
        accounts.setAccounts(accountList);

        Iterable<AccountEntity> loanList = accountRepository.findAccountEntitiesByType("DEBIT");
        accounts.setLoans(loanList);
        return accounts;
    }

    public void saveAccounts(Iterable<AccountEntity> accounts) {
        accountRepository.saveAll(accounts);
    }

    public void save(AccountEntity account) {
        accountRepository.save(account);
    }

    public void deleteAccount(AccountEntity account) {
        accountRepository.delete(account);
    }
}
