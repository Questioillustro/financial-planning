import {Component, OnInit} from '@angular/core';
import {FinanceService} from "../../service/finance.service";

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

  constructor(private financeService: FinanceService) { }

  ngOnInit() {
    this.loadFinances();
  }

  //
  // CASH FLOW
  //

  private loadFinances() {
    this.financeService.getFinances().subscribe((finances) => {
      this.bills = finances.bills;
      this.totalBills = finances.totalBills;

      this.budget = finances.budget;
      this.totalBudget = finances.totalBudget;

      this.incomeSources = finances.income;
      this.totalIncome = finances.totalIncome;

      this.monthlyIncome = finances.monthlyIncome;
      this.monthlyDelta = finances.monthlyDelta;

      this.accounts = finances.accounts;
      this.totalAccountsValue = finances.totalAccountsValue

      this.loans = finances.loans;
      this.totalDebt = finances.totalDebt;
    });
  }

  private saveFinances(finances: any) {
    this.financeService.saveFinances(finances).subscribe(() => {
      console.log("Finances saved", finances);
    });
    this.loadFinances();
  }

  private deleteFinance(finance: any) {
    this.financeService.deleteFinance(finance.id).subscribe(() => {
      console.log(finance, " deleted");
      this.loadFinances();
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
    this.saveFinances(this.incomeSources);
  }

  //
  // BILLS
  //

  private addBill() {
    this.bills.push({
      label: 'New Expense',
      dollarAmount: 0,
      debitType: 'BILL',
      flowType: 'DEBIT'
    });
    this.saveFinances(this.bills);
  }

  //
  // BUDGET
  //

  private addBudgetItem() {
    this.budget.push({
      label: 'New Budget Item',
      dollarAmount: 0,
      debitType: 'BUDGET',
      flowType: 'DEBIT'
    });
    this.saveFinances(this.budget);
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
    this.saveFinances(this.loans);
  }

  //
  // ACCOUNTS
  //

  addAccount() {
    this.accounts.push({
      label: 'New Account',
      dollarAmount: 0,
      apr: 0.0,
      type: 'CREDIT'
    });
    this.saveFinances(this.accounts);
  }
}
