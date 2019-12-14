import {Component, OnInit} from '@angular/core';
import {CashFlowService} from "../../service/cash-flow.service";
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
  private monthlyDelta: number;

  constructor(private cashFlowService: CashFlowService,
              private accountService: AccountService) { }

  ngOnInit() {
    this.loadCashFlow();
    this.loadAccounts();
  }

  //
  // CASH FLOW
  //

  private loadCashFlow() {
    this.cashFlowService.getCashFlow().subscribe((cashFlow) => {
      this.bills = cashFlow.bills;
      this.totalBills = cashFlow.totalBills;

      this.budget = cashFlow.budget;
      this.totalBudget = cashFlow.totalBudget;

      this.incomeSources = cashFlow.income;
      this.totalIncome = cashFlow.totalIncome;

      this.monthlyIncome = cashFlow.monthlyIncome;
      this.monthlyDelta = cashFlow.monthlyDelta;
    });
  }

  private deleteCashFlow(cashFlow: any) {
    this.cashFlowService.deleteCashFlow(cashFlow).subscribe(() => {
      console.log(cashFlow, " deleted");
      this.loadCashFlow();
    });
  }

  //
  // INCOME
  //

  private addIncome() {
    this.incomeSources.push({
      label: "New Income Source",
      dollarAmount: 0,
      flowType: 'CREDIT'
    });
    this.saveIncome();
  }

  private saveIncome() {
    this.cashFlowService.saveCashFlow(this.incomeSources).subscribe(() => {
      console.log("saved income");
      this.loadCashFlow();
    });
  }

  //
  // BILLS
  //

  addBill() {
    this.bills.push({
      label: 'New Expense',
      dollarAmount: 0,
      debitType: 'BILL',
      flowType: 'DEBIT'
    });
    this.saveBills();
  }

  saveBills() {
    this.cashFlowService.saveCashFlow(this.bills).subscribe(() => {
      console.log("expenses saved");
      this.loadCashFlow();
    });
  }

  //
  // BUDGET
  //

  addBudgetItem() {
    this.budget.push({
      label: 'New Budget Item',
      dollarAmount: 0,
      debitType: 'BUDGET',
      flowType: 'DEBIT'
    });
    this.saveBudget();
  }

  saveBudget() {
    this.cashFlowService.saveCashFlow(this.budget).subscribe(() => {
      console.log("Budget saved");
      this.loadCashFlow();
    });
  }

  //
  // DEBT
  //

  private addLoan() {
    this.loans.push({
      label: 'New Loan',
      dollarAmount: 0,
      apr: 1.0,
      type: 'DEBIT'
    });
    this.saveLoans();
  }

  private saveLoans() {
    this.accountService.saveAccounts(this.loans).subscribe(() => {
      console.log("Loans Saved");
    })
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

  addAccount() {
    this.accounts.push({
      label: 'New Account',
      dollarAmount: 0,
      apr: 0.0,
      type: 'CREDIT'
    });
    this.saveAccounts();
  }

  private saveAccounts() {
    this.accountService.saveAccounts(this.accounts).subscribe(() => {
      console.log("Accounts saved");
    });
  }
}
