package com.brewster.financialplanning.bootstrap;

import com.brewster.financialplanning.data.ExpenseEntity;
import com.brewster.financialplanning.data.IncomeEntity;
import com.brewster.financialplanning.data.LoanEntity;
import com.brewster.financialplanning.service.ExpenseService;
import com.brewster.financialplanning.service.IncomeService;
import com.brewster.financialplanning.service.LoanService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class BootstrapData {

    private final IncomeService incomeService;
    private final ExpenseService expenseService;
    private final LoanService loanService;

    public BootstrapData(final IncomeService incomeService,
                         final ExpenseService expenseService,
                         final LoanService loanService) {
        this.incomeService = incomeService;
        this.expenseService = expenseService;
        this.loanService = loanService;
    }

    @PostConstruct
    public void generateBaseline() {
        createIncome();
        createExpenses();
        createLoans();
    }

    private void createLoans() {
        LoanEntity loan = new LoanEntity();
        loan.setDollarAmount(49000L);
        loan.setApr(5.0);
        loan.setLabel("Student Loan");

        loanService.saveLoan(loan);

        LoanEntity loan2 = new LoanEntity();
        loan2.setDollarAmount(147000L);
        loan2.setApr(3.25);
        loan2.setLabel("Mortgage");

        loanService.saveLoan(loan2);
    }

    private void createExpenses() {
        ExpenseEntity expense = new ExpenseEntity();
        expense.setLabel("Housing");
        expense.setDollarAmount(1765L);

        expenseService.save(expense);

        ExpenseEntity expense2 = new ExpenseEntity();
        expense2.setLabel("Car Insurance");
        expense2.setDollarAmount(105L);

        expenseService.save(expense2);

        ExpenseEntity expense3 = new ExpenseEntity();
        expense3.setLabel("Phone");
        expense3.setDollarAmount(85L);

        expenseService.save(expense3);

        ExpenseEntity expense4 = new ExpenseEntity();
        expense4.setLabel("Utilities");
        expense4.setDollarAmount(225L);

        expenseService.save(expense4);

        ExpenseEntity expense5 = new ExpenseEntity();
        expense5.setLabel("Student Loan");
        expense5.setDollarAmount(665L);

        expenseService.save(expense5);

        ExpenseEntity expense6 = new ExpenseEntity();
        expense6.setLabel("Streaming Services");
        expense6.setDollarAmount(52L);

        expenseService.save(expense6);
    }

    private void createIncome() {
        IncomeEntity incomeEntity = new IncomeEntity();
        incomeEntity.setDollarAmount(62270L);
        incomeEntity.setLabel("Salary");

        incomeService.save(incomeEntity);

        IncomeEntity incomeEntity2 = new IncomeEntity();
        incomeEntity2.setDollarAmount(8400L);
        incomeEntity2.setLabel("Rent");

        incomeService.save(incomeEntity2);
    }
}
