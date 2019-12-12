import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class LoanService {

  constructor(private http: HttpClient) { }

  getLoans(): Observable<any> {
    return this.http.get('http://localhost:8080/brewster/finance/loan');
  }

  saveLoans(loans: any) {
    return this.http.put('http://localhost:8080/brewster/finance/loan', loans);
  }
}
