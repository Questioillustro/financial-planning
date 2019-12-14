import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CashFlowService {

  constructor(private http: HttpClient) { }

  getCashFlow(): Observable<any> {
    return this.http.get('http://localhost:8080/brewster/finance/cashflow');
  }

  saveCashFlow(cashFlow: any) {
    return this.http.put('http://localhost:8080/brewster/finance/cashflow', cashFlow);
  }

  deleteCashFlow(cashFlow: any) {
    return this.http.delete(`http://localhost:8080/brewster/finance/cashflow/${cashFlow.id}`);
  }
}
