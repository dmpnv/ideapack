import { Component, OnInit } from '@angular/core';
import {OrderService} from '../../../build/openapi';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  constructor(private orderService: OrderService) {
  }

  ngOnInit(): void {
  }

}
