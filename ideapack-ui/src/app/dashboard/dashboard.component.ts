import { Component, OnInit } from '@angular/core';
import {OrderService} from '../../../build/openapi';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {
  tableData: any;
  displayedColumns: any = ['orderId', 'supplier', 'sender', 'recipient', 'shippingDate', 'status'];

  constructor(private orderService: OrderService) {
  }

  ngOnInit(): void {
    this.loadData();
  }

  loadData(): void {
    this.orderService.getOrders().subscribe(value => {
      console.log('--> getOrders: ', JSON.stringify(value));
      this.tableData = value.orders;
    });
  }

}
