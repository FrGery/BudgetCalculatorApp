import {Component, OnInit} from '@angular/core';
import Swal from 'sweetalert2';
import {CreateExpenseCommandModel} from '../../models/create-expense-command-model.model';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {BudgetService} from '../../service/budget.service';
import {CategoryListItemModel} from '../../models/category-list-item-model.model';


class CategoryListItem {
}

@Component({
  selector: 'app-expense-form',
  standalone: false,
  templateUrl: './expense-form.component.html',
  styleUrl: './expense-form.component.css'
})
export class ExpenseFormComponent implements OnInit {
  form!: FormGroup;
  categories: CategoryListItemModel[] = [];

  constructor(private fb: FormBuilder, private budgetService: BudgetService) {}

  ngOnInit(): void {
    this.form = this.fb.group({
      amount: [null, [Validators.required, Validators.min(1)]],
      description: [''],
      date: ['', Validators.required],
      categoryId: ['', Validators.required]
    });

    this.budgetService.getCategories().subscribe(data => {
      this.categories = data;
      console.log('Loaded categories:', this.categories);
    });
  }

  onSubmit(): void {
    if (this.form.invalid) {
      Swal.fire({
        icon: 'warning',
        title: 'Please fill all required fields!',
        timer: 2000,
        toast: true,
        showConfirmButton: false,
        position: 'top-end'
      });
      return;
    }

    const expense: CreateExpenseCommandModel = {
      amount: this.form.value.amount,
      description: this.form.value.description,
      date: this.form.value.date,
      categoryId: Number(this.form.value.categoryId)
    };
    console.log('Creating expense:', expense);

    this.budgetService.createExpense(expense).subscribe({
      next: () => {
        Swal.fire({
          icon: 'success',
          title: 'Expense added!',
          timer: 2000,
          toast: true,
          position: 'top-end',
          showConfirmButton: false
        });
        this.form.reset();
      },
      error: err => {
        console.error('Error saving expense:', err);
        Swal.fire({
          icon: 'error',
          title: 'Failed to add expense',
          text: 'Something went wrong. Try again later.',
        });
      }
    });
  }
}
