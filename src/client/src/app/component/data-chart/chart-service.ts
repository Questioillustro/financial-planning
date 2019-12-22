import {Injectable} from "@angular/core";

@Injectable()
export class ChartService {

  constructor(private window: Window) {

  }

  public createNetWorthChartData(finances: any): any {
    let loans = finances.loans;
    let accounts = finances.accounts;

    // Create the data table.
    // @ts-ignore
    let data = new this.window.google.visualization.DataTable();
    data.addColumn('string', 'Topping');
    data.addColumn('number', 'Slices');
    data.addRows([
      ['Mushrooms', 3],
      ['Pepperoni', 2]
    ]);

    // Set chart options
    let options = {'title':'How Much Pizza I Ate Last Night',
      'width':400,
      'height':300};

    return {
      data: data,
      options: options
    }
  }

}
