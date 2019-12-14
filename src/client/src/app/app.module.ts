import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {HttpClientModule} from "@angular/common/http";
import { IncomeComponent } from './component/income/income.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatCardModule} from "@angular/material/card";
import {MatButtonModule} from "@angular/material/button";
import {FormsModule} from "@angular/forms";
import {MatInputModule} from "@angular/material/input";
import {FlexModule} from "@angular/flex-layout";
import { ExpenseComponent } from './component/expense/expense.component';
import {MatExpansionModule} from "@angular/material/expansion";
import { DebtComponent } from './component/debt/debt.component';
import { BudgetComponent } from './component/budget/budget.component';
import { OverviewBasicComponent } from './component/overview-basic/overview-basic.component';
import { FinanceComponent } from './component/finance/finance.component';
import {MatListModule} from "@angular/material/list";
import {MatTableModule} from "@angular/material/table";
import { AccountComponent } from './component/account/account.component';


@NgModule({
  declarations: [
    AppComponent,
    IncomeComponent,
    ExpenseComponent,
    DebtComponent,
    BudgetComponent,
    OverviewBasicComponent,
    FinanceComponent,
    AccountComponent
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
    MatTableModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
