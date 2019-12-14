import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-finance-item',
  templateUrl: './finance-item.component.html',
  styleUrls: ['./finance-item.component.css']
})
export class FinanceItemComponent implements OnInit {
  @Input() item: any;

  @Output() deleteItem = new EventEmitter();

  constructor() { }

  ngOnInit() {
  }

  delete(item: any) {
    this.deleteItem.next(item);
  }
}
