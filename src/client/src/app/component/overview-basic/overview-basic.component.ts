import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-overview-basic',
  templateUrl: './overview-basic.component.html',
  styleUrls: ['./overview-basic.component.css']
})
export class OverviewBasicComponent implements OnInit {

  @Input() monthlyIncome: number = 0;
  @Input() totalBills: number = 0;
  @Input() totalBudget: number = 0;

  constructor() { }

  ngOnInit() {
  }

  isDebitOrCredit() {
    return this.isDebit() ? 'debit' : 'credit';
  }

  isDebit() {
    return this.getMonthlyDelta() < 0;
  }

  getAbsoluteMonthlyDelta() {
    return Math.abs(this.getMonthlyDelta());
  }

  getMonthlyDelta() {
    return this.monthlyIncome - this.totalBills - this.totalBudget;
  }
}
