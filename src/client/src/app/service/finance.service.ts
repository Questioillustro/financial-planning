import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class FinanceService {

  constructor(private http: HttpClient) { }

  getFinances(): Observable<any> {
    return this.http.get('http://localhost:8080/brewster/finance');
  }

  saveFinances(finances: any) {
    return this.http.put('http://localhost:8080/brewster/finance', finances);
  }

  deleteFinance(id: number) {
    return this.http.delete(`http://localhost:8080/brewster/finance/${id}`)
  }
}
