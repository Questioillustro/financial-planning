import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import * as _ from 'lodash';

@Component({
  selector: 'app-debt',
  templateUrl: './debt.component.html',
  styleUrls: ['./debt.component.css']
})
export class DebtComponent implements OnInit {

  @Input() amortizations: any = [];

  @Output() updatePayment = new EventEmitter();

  constructor() { }

  ngOnInit() {
  }

  update() {
    this.updatePayment.next(_.map(this.amortizations, 'loan'));
  }
}
