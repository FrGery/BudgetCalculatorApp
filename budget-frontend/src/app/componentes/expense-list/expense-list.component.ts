import {Component, OnInit} from '@angular/core';
import {ExpenseListItemModel} from '../../models/expense-list-item-model.model';
import {BudgetService} from '../../service/budget.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-expense-list',
  standalone: false,
  templateUrl: './expense-list.component.html',
  styleUrl: './expense-list.component.css'
})
export class ExpenseListComponent implements OnInit {
  expenses: ExpenseListItemModel[] = [];

  constructor(private budgetService: BudgetService,
              private router: Router) {
  }


  ngOnInit(): void {
    this.loadExpenses();
  }

  private loadExpenses() {
    this.budgetService.fetchExpenses().subscribe({
      next: value => this.expenses = value,
      error: err => console.error(err)
    })
  }
}
