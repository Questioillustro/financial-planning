import {Component, OnInit} from '@angular/core';
import {FinanceService} from "../../service/finance.service";

@Component({
  selector: 'app-finance',
  templateUrl: './finance.component.html',
  styleUrls: ['./finance.component.css']
})
export class FinanceComponent implements OnInit {

  private finances: any;

  constructor(private financeService: FinanceService) { }

  ngOnInit() {
    this.loadFinances();
  }

  private loadFinances() {
    this.financeService.getFinances().subscribe((finances) => {
      console.log("Finances loaded", finances);
      this.finances = finances;
    });
  }

  private saveFinances(finances: any) {
    this.financeService.saveFinances(finances).subscribe(() => {
      console.log("Finances saved", finances);
      this.loadFinances();
    });
  }

  private deleteFinance(finance: any) {
    this.financeService.deleteFinance(finance.id).subscribe(() => {
      console.log("Finance deleted", finance);
      this.loadFinances();
    });
  }

  //
  // INCOME
  //

  private addIncome() {
    this.finances.income.push({
      label: "New Income Source",
      accrualAmount: 0.0,
      balance: null,
      financeType: 'INCOME',
      accrualType: 'FLAT',
      accrualFrequency: 'WEEKLY'
    });
    this.saveFinances(this.finances.income);
  }

  //
  // BILLS
  //

  private addBill() {
    this.finances.bills.push({
      label: 'New Bill',
      accrualAmount: 0.0,
      balance: null,
      financeType: 'BILL',
      accrualType: 'FLAT',
      accrualFrequency: 'MONTHLY'
    });
    this.saveFinances(this.finances.bills);
  }

  //
  // BUDGET
  //

  private addBudgetItem() {
    this.finances.budget.push({
      label: 'New Budget Item',
      accrualAmount: 0.0,
      balance: null,
      financeType: 'BUDGET',
      accrualType: 'FLAT',
      accrualFrequency: 'MONTHLY'
    });
    this.saveFinances(this.finances.budget);
  }

  //
  // DEBT
  //

  private addLoan() {
    this.finances.loans.push({
      label: 'New Loan',
      accrualAmount: 0.0,
      balance: 0.0,
      financeType: 'LOAN',
      accrualType: 'PERCENT',
      accrualFrequency: 'ANNUALLY'
    });
    this.saveFinances(this.finances.loans);
  }

  //
  // ACCOUNTS
  //

  addAccount() {
    this.finances.accounts.push({
      label: 'New Account',
      accrualAmount: 0.0,
      balance: 0.0,
      financeType: 'ACCOUNT',
      accrualType: 'PERCENT',
      accrualFrequency: 'ANNUALLY'
    });
    this.saveFinances(this.finances.accounts);
  }
}
