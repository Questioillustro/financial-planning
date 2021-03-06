import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {HttpClientModule} from "@angular/common/http";
import { IncomeComponent } from './component/income/income.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatCardModule} from "@angular/material/card";
import {MatButtonModule} from "@angular/material/button";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatInputModule} from "@angular/material/input";
import {FlexModule} from "@angular/flex-layout";
import { ExpenseComponent } from './component/expense/expense.component';
import {MatExpansionModule} from "@angular/material/expansion";
import { LoansComponent } from './component/loans/loans.component';
import { BudgetComponent } from './component/budget/budget.component';
import { CashFlowComponent } from './component/cashflow/cash-flow.component';
import { FinanceComponent } from './component/finance/finance.component';
import {MatListModule} from "@angular/material/list";
import {MatTableModule} from "@angular/material/table";
import { AccountComponent } from './component/account/account.component';
import { FinanceItemListComponent } from './component/finance-item-list/finance-item-list.component';
import { FinanceItemComponent } from './component/finance-item-list/finance-item/finance-item.component';
import {MatSelectModule} from "@angular/material/select";
import { DebtComponent } from './component/debt/debt.component';
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MatNativeDateModule} from "@angular/material/core";
import { DataChartComponent } from './component/data-chart/data-chart.component';
import {ChartService} from "./component/data-chart/chart-service";


@NgModule({
  declarations: [
    AppComponent,
    IncomeComponent,
    ExpenseComponent,
    LoansComponent,
    BudgetComponent,
    CashFlowComponent,
    FinanceComponent,
    AccountComponent,
    FinanceItemListComponent,
    FinanceItemComponent,
    DebtComponent,
    DataChartComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatCardModule,
    MatButtonModule,
    FormsModule,
    MatInputModule,
    FlexModule,
    MatExpansionModule,
    MatListModule,
    MatTableModule,
    MatSelectModule,
    MatDatepickerModule,
    MatNativeDateModule,
    ReactiveFormsModule
  ],
  providers: [{provide: Window, useValue: window}, ChartService],
  bootstrap: [AppComponent]
})
export class AppModule { }
