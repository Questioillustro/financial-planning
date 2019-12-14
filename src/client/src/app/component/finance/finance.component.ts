import {Component, OnInit} from '@angular/core';
import {ExpenseService} from "../../service/expense.service";
import {IncomeService} from "../../service/income.service";
import * as _ from 'lodash';
import {AccountService} from "../../service/account.service";

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
  private accounts: any;

  private totalIncome: number;
  private monthlyIncome: number;
  private totalBills: number;
  private totalBudget: number;
  private totalDebt: number;
  private totalAccountsValue: number;

  constructor(private expenseService: ExpenseService,
              private incomeService: IncomeService,
              private accountService: AccountService) { }

  ngOnInit() {
    this.loadExpenses();
    this.loadIncome();
    this.loadAccounts();
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
      this.loadIncome();
    });
  }

  private setTotalIncome() {
    let i = 0;
    this.incomeSources.forEach((is) => {
      i += is.dollarAmount;
    });
    this.totalIncome = i;
    this.monthlyIncome = _.round(i/12);
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
      this.loadExpenses();
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
      this.loadExpenses();
    });
  }

  //
  // DEBT
  //

  private addLoan() {
    this.loans.push({
      label: 'New Loan',
      dollarAmount: 0,
      apr: 1.0
    });
  }

  //
  // ACCOUNTS
  //

  private loadAccounts() {
    this.accountService.getAccounts().subscribe((accounts) => {
      this.accounts = accounts.accounts;
      this.totalAccountsValue = accounts.totalAccountsValue

      this.loans = accounts.loans;
      this.totalDebt = accounts.totalDebt;
    });
  }
}
