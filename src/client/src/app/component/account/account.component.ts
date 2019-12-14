import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {

  @Input() accounts: any = [];
  @Input() totalAccountsValue: number = 0;

  constructor() { }

  ngOnInit() {
  }

  add() {

  }

  save() {

  }
}
