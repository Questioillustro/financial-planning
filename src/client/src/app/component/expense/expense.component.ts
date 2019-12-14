import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-expense',
  templateUrl: './expense.component.html',
  styleUrls: ['./expense.component.css']
})
export class ExpenseComponent implements OnInit {

  @Input() bills: any = [];
  @Input() totalBills: number = 0;

  @Output() addBill = new EventEmitter();
  @Output() saveBills = new EventEmitter();
  @Output() deleteBill = new EventEmitter();

  constructor() { }

  ngOnInit() {
  }

  delete(expense: any) {
    this.deleteBill.next(expense);
  }

  add() {
    this.addBill.next();
  }

  save() {
    this.saveBills.next(this.bills);
  }
}
