import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";
import {FormControl} from "@angular/forms";

@Injectable({
  providedIn: 'root'
})
export class AmortizationService {

  constructor(private http: HttpClient) { }

  getAmortizationSchedule(id: number): Observable<any> {
    return this.http.get<any>(`http://localhost:8080/brewster/amortization/${id}`).pipe(
      map(schedule => {
        schedule.loan.paymentDate = new Date(schedule.loan.paymentDate).toISOString();
        return schedule;
      })
    );
  }
}
