import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-debt',
  templateUrl: './debt.component.html',
  styleUrls: ['./debt.component.css']
})
export class DebtComponent implements OnInit {

  @Input() amortizations: any = [];

  constructor() { }

  ngOnInit() {
  }

  update() {

  }
}
