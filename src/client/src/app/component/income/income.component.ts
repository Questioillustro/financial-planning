import { Component, OnInit } from '@angular/core';
import {IncomeService} from "../../service/income.service";

@Component({
  selector: 'app-income',
  templateUrl: './income.component.html',
  styleUrls: ['./income.component.css']
})
export class IncomeComponent implements OnInit {

  private incomeSources: any = [];

  constructor(private incomeService: IncomeService) { }

  ngOnInit() {
    this.incomeService.getIncome().subscribe((income) => {
      this.incomeSources = income;
    });
  }

  applyIncome() {
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
}
