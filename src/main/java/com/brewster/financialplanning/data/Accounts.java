package com.brewster.financialplanning.data;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Accounts {

    private Iterable<AccountEntity> accounts;
    private Iterable<AccountEntity> loans;

    private Long totalAccountsValue;
    private Long totalDebt;

    public void setAccounts(Iterable<AccountEntity> accounts) {
        this.accounts = accounts;

        totalAccountsValue = 0L;
        this.accounts.forEach((a) -> {
           totalAccountsValue += a.getDollarAmount();
        });
    }

    public void setLoans(Iterable<AccountEntity> loans) {
        this.loans = loans;

        totalDebt = 0L;
        this.loans.forEach((l) -> {
            totalDebt += l.getDollarAmount();
        });
    }
}
