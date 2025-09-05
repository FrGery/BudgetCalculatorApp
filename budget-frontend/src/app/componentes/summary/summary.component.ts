import { Component, OnInit } from '@angular/core';
import {
  Chart,
  PieController,
  ArcElement,
  Tooltip,
  Legend,
  Title,
  ChartData,
  ChartType
} from 'chart.js';
import { BudgetService } from '../../service/budget.service';
import { SummaryItemModel } from '../../models/summary-item-model.model';
Chart.register(PieController, ArcElement, Tooltip, Legend, Title);

@Component({
  selector: 'app-summary',
  standalone: false,
  templateUrl: './summary.component.html',
  styleUrl: './summary.component.css'
})
export class SummaryComponent implements OnInit {
  summary: SummaryItemModel[] = [];

  // ✅ Pie chart adatszerkezete
  chartData: ChartData<'pie', number[], string> = {
    labels: [],
    datasets: [
      {
        data: [],
        backgroundColor: [
          '#4bc0c0', '#36a2eb', '#9966ff', '#ffcd56', '#ff6384', '#c9cbcf'
        ]
      }
    ]
  };

  chartType: ChartType = 'pie';

  constructor(private budgetService: BudgetService) {}

  ngOnInit(): void {
    this.budgetService.getSummary().subscribe(data => {
      this.summary = data;
      this.chartData.labels = data.map(item => item.categoryName);
      this.chartData.datasets[0].data = data.map(item => item.amount);
    });
  }
}
