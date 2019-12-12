import { Component, OnInit } from '@angular/core';
import {LoanService} from "../../service/loan.service";

@Component({
  selector: 'app-loan',
  templateUrl: './debt.component.html',
  styleUrls: ['./debt.component.css']
})
export class DebtComponent implements OnInit {
  loans: any;
  totalDebt: number = 0;

  constructor(private loanService: LoanService) { }

  ngOnInit() {
    this.loanService.getLoans().subscribe((loans) => {
      this.loans = loans;
      this.setTotalDebt();
    });
  }

  addLoan() {
    this.loans.push({
      label: 'New Loan',
      dollarAmount: 0,
      apr: 1.0
    });
  }

  saveLoans() {
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
