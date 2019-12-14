import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-cashflow',
  templateUrl: './cash-flow.component.html',
  styleUrls: ['./cash-flow.component.css']
})
export class CashFlowComponent implements OnInit {

  @Input() monthlyDelta: number = 0;
  @Input() monthlyIncome: number = 0;
  @Input() totalBills: number = 0;
  @Input() totalBudget: number = 0;

  constructor() { }

  ngOnInit() {
  }
}
