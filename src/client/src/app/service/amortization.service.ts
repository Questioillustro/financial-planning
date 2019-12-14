import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AmortizationService {

  constructor(private http: HttpClient) { }

  getAmortizationSchedule(id: number): Observable<any> {
    return this.http.get(`http://localhost:8080/brewster/amortization/${id}`);
  }
}
