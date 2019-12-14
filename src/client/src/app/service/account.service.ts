import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  constructor(private http: HttpClient) { }

  getAccounts(): Observable<any> {
    return this.http.get('http://localhost:8080/brewster/finance/account');
  }

  saveAccounts(accounts: any) {
    return this.http.put('http://localhost:8080/brewster/finance/account', accounts);
  }
}
