import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {ExpenseService} from "../../service/expense.service";

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

  constructor(private expenseService: ExpenseService) { }

  ngOnInit() {
  }

  addExpense() {
    this.addBill.next();
  }

  saveExpense() {
    this.saveBills.next();
  }
}
