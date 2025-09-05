import {Injectable} from '@angular/core';
import {ExpenseListItemModel} from '../models/expense-list-item-model.model';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {CategoryListItemModel} from '../models/category-list-item-model.model';
import {SummaryItemModel} from '../models/summary-item-model.model';
import {CreateExpenseCommandModel} from '../models/create-expense-command-model.model';
import {CreateCategoryCommandModel} from '../models/create-category-command-model.model';

const BASE_URL = 'http://localhost:8080/api/bugets';

@Injectable({
  providedIn: 'root'
})

export class BudgetService {

  constructor(private http: HttpClient) {
  }

  fetchExpenses(): Observable<ExpenseListItemModel[]> {
    return this.http.get<ExpenseListItemModel[]>('http://localhost:8080/api/budgets');

  }

  getCategories(): Observable<CategoryListItemModel[]> {
    return this.http.get<CategoryListItemModel[]>('http://localhost:8080/api/budgets/categories');
  }

  getSummary(): Observable<SummaryItemModel[]> {
    return this.http.get<SummaryItemModel[]>('http://localhost:8080/api/budgets/summary');
  }

  createExpense(command: CreateExpenseCommandModel): Observable<any> {
    return this.http.post('http://localhost:8080/api/budgets/expenses', command);
  }

  createCategory(command: CreateCategoryCommandModel): Observable<any> {
    return this.http.post('http://localhost:8080/api/budgets/categories', command);
  }
}
