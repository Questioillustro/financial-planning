import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-finance-item-list',
  templateUrl: './finance-item-list.component.html',
  styleUrls: ['./finance-item-list.component.css']
})
export class FinanceItemListComponent implements OnInit {

  @Input() listTitle: string = '';
  @Input() totalLabel: string = '';
  @Input() total: number = 0;
  @Input() subTitle: string = '';
  @Input() items: any = [];

  constructor() { }

  ngOnInit() {
  }

  delete(item: any) {

  }

  add() {

  }

  save() {

  }
}
