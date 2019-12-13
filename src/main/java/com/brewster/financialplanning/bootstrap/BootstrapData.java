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
        createBudget();
        createLoans();
    }

    private void createBudget() {
        ExpenseEntity expense = new ExpenseEntity();
        expense.setLabel("Gas");
        expense.setDollarAmount(100L);
        expense.setType("BUDGET");

        expenseService.save(expense);

        ExpenseEntity expense2 = new ExpenseEntity();
        expense2.setLabel("Food");
        expense2.setDollarAmount(300L);
        expense2.setType("BUDGET");

        expenseService.save(expense2);

        ExpenseEntity expense3 = new ExpenseEntity();
        expense3.setLabel("Cats");
        expense3.setDollarAmount(60L);
        expense3.setType("BUDGET");

        expenseService.save(expense3);

        ExpenseEntity expense4 = new ExpenseEntity();
        expense4.setLabel("Alcohol");
        expense4.setDollarAmount(80L);
        expense4.setType("BUDGET");

        expenseService.save(expense4);

        ExpenseEntity expense5 = new ExpenseEntity();
        expense5.setLabel("Lunches");
        expense5.setDollarAmount(133L);
        expense5.setType("BUDGET");

        expenseService.save(expense5);

        ExpenseEntity expense6 = new ExpenseEntity();
        expense6.setLabel("Cigarettes");
        expense6.setDollarAmount(200L);
        expense6.setType("BUDGET");

        expenseService.save(expense6);
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
        expense.setType("BILL");

        expenseService.save(expense);

        ExpenseEntity expense2 = new ExpenseEntity();
        expense2.setLabel("Car Insurance");
        expense2.setDollarAmount(105L);
        expense2.setType("BILL");

        expenseService.save(expense2);

        ExpenseEntity expense3 = new ExpenseEntity();
        expense3.setLabel("Phone");
        expense3.setDollarAmount(85L);
        expense3.setType("BILL");

        expenseService.save(expense3);

        ExpenseEntity expense4 = new ExpenseEntity();
        expense4.setLabel("Utilities");
        expense4.setDollarAmount(225L);
        expense4.setType("BILL");

        expenseService.save(expense4);

        ExpenseEntity expense5 = new ExpenseEntity();
        expense5.setLabel("Student Loan");
        expense5.setDollarAmount(665L);
        expense5.setType("BILL");

        expenseService.save(expense5);

        ExpenseEntity expense6 = new ExpenseEntity();
        expense6.setLabel("Streaming Services");
        expense6.setDollarAmount(52L);
        expense6.setType("BILL");

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
