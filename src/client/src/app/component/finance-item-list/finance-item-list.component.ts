import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

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

  @Output() deleteItem = new EventEmitter();
  @Output() saveItems = new EventEmitter();
  @Output() addItem = new EventEmitter();

  constructor() { }

  ngOnInit() {
  }

  delete(item: any) {
    this.deleteItem.next(item);
  }

  add() {
    this.addItem.next();
  }

  save() {
    this.saveItems.next(this.items);
  }
}
