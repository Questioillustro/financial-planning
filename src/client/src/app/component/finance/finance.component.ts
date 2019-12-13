import { Component, OnInit } from '@angular/core';
import {LoanService} from "../../service/loan.service";
import {ExpenseService} from "../../service/expense.service";
import {IncomeService} from "../../service/income.service";

@Component({
  selector: 'app-finance',
  templateUrl: './finance.component.html',
  styleUrls: ['./finance.component.css']
})
export class FinanceComponent implements OnInit {

  private incomeSources: any;
  private bills: any;
  private budget: any;
  private loans: any;

  private totalIncome: number;
  private totalBills: number;
  private totalBudget: number;
  private totalDebt: number;

  constructor(private loanService: LoanService,
              private expenseService: ExpenseService,
              private incomeService: IncomeService) { }

  ngOnInit() {
    this.loadExpenses();
    this.loadIncome();
    this.loadDebt();
  }

  loadExpenses() {
    this.expenseService.getExpenses().subscribe((expenses) => {
      this.bills = expenses.bills;
      this.totalBills = expenses.totalBills;

      this.budget = expenses.budget;
      this.totalBudget = expenses.totalBudget;
    });
  }

  //
  // INCOME
  //

  private loadIncome() {
    this.incomeService.getIncome().subscribe((income) => {
      this.incomeSources = income;
      this.setTotalIncome();
    });
  }

  private addIncome() {
    this.incomeSources.push({
      label: "New Income Source",
      dollarAmount: 0
    })
  }

  private saveIncome() {
    this.incomeService.saveIncome(this.incomeSources).subscribe(() => {
      console.log("saved income");
    });
  }

  private setTotalIncome() {
    let i = 0;
    this.incomeSources.forEach((is) => {
      i += is.dollarAmount;
    });
    this.totalIncome = i;
  }

  //
  // BILLS
  //

  addBill() {
    this.bills.push({
      label: 'New Expense',
      dollarAmount: 0,
      type: 'BILL'
    });
  }

  saveBills() {
    this.expenseService.saveExpenses(this.bills).subscribe(() => {
      console.log("expenses saved");
    });
  }

  //
  // BUDGET
  //

  addBudgetItem() {
    this.budget.push({
      label: 'New Budget Item',
      dollarAmount: 0,
      type: 'BUDGET'
    })
  }

  saveBudget() {
    this.expenseService.saveExpenses(this.budget).subscribe(() => {
      console.log("Budget saved");
    });
  }

  //
  // DEBT
  //

  private loadDebt() {
    this.loanService.getLoans().subscribe((loans) => {
      this.loans = loans;
      this.setTotalDebt();
    });
  }

  private addLoan() {
    this.loans.push({
      label: 'New Loan',
      dollarAmount: 0,
      apr: 1.0
    });
  }

  private saveLoans() {
    this.loanService.saveLoans(this.loans).subscribe(() => {
      console.log("Loans Saved");
    });
  }

  private setTotalDebt() {
    let td = 0;
    this.loans.forEach((l) => {
      td += l.dollarAmount;
    });
    this.totalDebt = td;
  }
}
