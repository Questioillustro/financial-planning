import { Component, OnInit } from '@angular/core';
import {IncomeService} from "../../service/income.service";

@Component({
  selector: 'app-income',
  templateUrl: './income.component.html',
  styleUrls: ['./income.component.css']
})
export class IncomeComponent implements OnInit {

  private incomeSources: any = [];
  totalIncome: number = 0;

  constructor(private incomeService: IncomeService) { }

  ngOnInit() {
    this.incomeService.getIncome().subscribe((income) => {
      this.incomeSources = income;
      this.setTotalIncome();
    });
  }

  saveIncome() {
    this.incomeService.saveIncome(this.incomeSources).subscribe(() => {
      console.log("saved");
    });
  }

  addIncome() {
    this.incomeSources.push({
      label: "New Income Source",
      dollarAmount: 0
    })
  }

  private setTotalIncome() {
    let i = 0;
    this.incomeSources.forEach((is) => {
      i += is.dollarAmount;
    });
    this.totalIncome = i;
  }
}
