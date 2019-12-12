import { Component, OnInit } from '@angular/core';
import {ExpenseService} from "../../service/expense.service";

@Component({
  selector: 'app-expense',
  templateUrl: './expense.component.html',
  styleUrls: ['./expense.component.css']
})
export class ExpenseComponent implements OnInit {
  expenses: any;
  totalExpenses: number = 0;

  constructor(private expenseService: ExpenseService) { }

  ngOnInit() {
    this.expenseService.getExpenses().subscribe((expenses) => {
      this.expenses = expenses;
      this.setTotalExpenses();
    })
  }

  addExpense() {
    this.expenses.push({
      label: 'New Expense',
      dollarAmount: 0
    });
  }

  saveExpense() {
    this.expenseService.saveExpenses(this.expenses).subscribe(() => {
      console.log("expenses saved");
    });
  }

  private setTotalExpenses() {
    let te = 0;
    this.expenses.forEach((e) => {
      te += e.dollarAmount;
    });
    this.totalExpenses = te;
  }
}
