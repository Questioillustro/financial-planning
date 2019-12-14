import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {

  @Input() accounts: any = [];
  @Input() totalAccountsValue: number = 0;

  @Output() addAccount = new EventEmitter();
  @Output() saveAccounts = new EventEmitter();

  constructor() { }

  ngOnInit() {
  }

  add() {
    this.addAccount.next();
  }

  save() {
    this.saveAccounts.next();
  }
}
