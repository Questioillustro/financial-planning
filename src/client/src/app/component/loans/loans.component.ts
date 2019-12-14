import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-loan',
  templateUrl: './loans.component.html',
  styleUrls: ['./loans.component.css']
})
export class LoansComponent implements OnInit {

  @Input() loans: any = [];
  @Input() totalLoans: number = 0;

  @Output() addLoan = new EventEmitter();
  @Output() saveLoans = new EventEmitter();
  @Output() deleteLoan = new EventEmitter();

  constructor() { }

  ngOnInit() {
  }

  add() {
    this.addLoan.next();
  }

  save() {
    this.saveLoans.next(this.loans);
  }

  delete(loan: any) {
    this.deleteLoan.next(loan);
  }
}
