import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {CashFlowService} from "../../service/cash-flow.service";

@Component({
  selector: 'app-income',
  templateUrl: './income.component.html',
  styleUrls: ['./income.component.css']
})
export class IncomeComponent implements OnInit {

  @Input() private incomeSources: any = [];
  @Input() totalIncome: number = 0;

  @Output() saveIncome = new EventEmitter();
  @Output() addIncome = new EventEmitter();
  @Output() deleteIncome = new EventEmitter();

  constructor() { }

  ngOnInit() {
  }

  save() {
    this.saveIncome.next();
  }

  add() {
    this.addIncome.next();
  }

  delete(cashFlow: any) {
    this.deleteIncome.next(cashFlow);
  }
}
