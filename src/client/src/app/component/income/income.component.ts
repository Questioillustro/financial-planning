import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-income',
  templateUrl: './income.component.html',
  styleUrls: ['./income.component.css']
})
export class IncomeComponent implements OnInit {

  @Input() private incomeSources: any = [];
  @Input() private totalIncome: number = 0;

  @Output() private saveIncome = new EventEmitter();
  @Output() private addIncome = new EventEmitter();
  @Output() private deleteIncome = new EventEmitter();

  constructor() { }

  ngOnInit() {
  }

  save() {
    this.saveIncome.next(this.incomeSources);
  }

  add() {
    this.addIncome.next();
  }

  delete(income: any) {
    this.deleteIncome.next(income);
  }
}
