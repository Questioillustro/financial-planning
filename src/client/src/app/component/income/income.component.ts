import { Component, OnInit } from '@angular/core';
import {IncomeService} from "../../service/income.service";

@Component({
  selector: 'app-income',
  templateUrl: './income.component.html',
  styleUrls: ['./income.component.css']
})
export class IncomeComponent implements OnInit {

  private income: any = {};

  constructor(private incomeService: IncomeService) { }

  ngOnInit() {
    this.incomeService.getIncome().subscribe((income) => {
      this.income = income;
    });
  }

}
