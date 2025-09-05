import {Component, OnInit} from '@angular/core';
import {BudgetService} from '../../service/budget.service';
import {CategoryListItemModel} from '../../models/category-list-item-model.model';

@Component({
  selector: 'app-category-list',
  standalone: false,
  templateUrl: './category-list.component.html',
  styleUrl: './category-list.component.css'
})
export class CategoryListComponent implements OnInit {
  categories: CategoryListItemModel[] = [];

  constructor(private budgetService: BudgetService) {
  }

  ngOnInit(): void {
    this.budgetService.getCategories().subscribe(data => {
      this.categories = data;
    });
  }
}
