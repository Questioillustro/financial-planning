import {Component, Input, OnInit} from '@angular/core';
import {ChartService} from "./chart-service";
import * as _ from 'lodash';

@Component({
  selector: 'app-data-chart',
  templateUrl: './data-chart.component.html',
  styleUrls: ['./data-chart.component.css']
})
export class DataChartComponent implements OnInit {

  googleApiLoaded: boolean = false;
  _finances: any = {};

  @Input()
  set finances(finances: any) {
    if (!_.isEmpty(finances)) {
      this._finances = finances;
      this.buildChart();
    }
  }

  constructor(private window: Window, private chartService: ChartService) {
    // @ts-ignore
    this.window.google.charts.setOnLoadCallback(this.apiLoaded.bind(this));
    console.log("window", window)
  }

  ngOnInit() {
  }

  buildChart() {
    if (!this.googleApiLoaded) {
      return;
    }

    let data = this.chartService.createNetWorthChartData(this._finances);

    // @ts-ignore
    let chart = new window.google.visualization.PieChart(document.getElementById('chart_div'));
    chart.draw(data.data, data.options);
  }

  apiLoaded() {
    this.googleApiLoaded = true;

    if (!_.isEmpty(this._finances)) {
      this.buildChart();
    }
    console.log("google charts loaded");
  }

}
