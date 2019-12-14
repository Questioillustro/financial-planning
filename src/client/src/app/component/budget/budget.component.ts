import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-budget',
  templateUrl: './budget.component.html',
  styleUrls: ['./budget.component.css']
})
export class BudgetComponent implements OnInit {

  @Input() totalBudget: number = 0;
  @Input() budget: any = [];

  @Output() addBudgetItem = new EventEmitter();
  @Output() saveBudget = new EventEmitter();

  constructor() { }

  ngOnInit() {
  }

  add() {
    this.addBudgetItem.next();
  }

  save() {
    this.saveBudget.next();
  }
}
