import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import Swal from 'sweetalert2';
import { BudgetService } from '../../service/budget.service';
import { CreateCategoryCommandModel } from '../../models/create-category-command-model.model';


@Component({
  selector: 'app-category-form',
  standalone: false,
  templateUrl: './category-form.component.html',
  styleUrl: './category-form.component.css'
})
export class CategoryFormComponent implements OnInit {
  form!: FormGroup;

  constructor(private fb: FormBuilder, private budgetService: BudgetService) {}

  ngOnInit(): void {
    this.form = this.fb.group({
      name: ['', Validators.required]
    });
  }

  onSubmit(): void {
    if (this.form.invalid) {
      Swal.fire({
        icon: 'warning',
        title: 'Category name required!',
        toast: true,
        timer: 2000,
        position: 'top-end',
        showConfirmButton: false
      });
      return;
    }

    const category: CreateCategoryCommandModel = this.form.value;

    this.budgetService.createCategory(category).subscribe({
      next: () => {
        Swal.fire({
          icon: 'success',
          title: 'Category created!',
          toast: true,
          timer: 2000,
          position: 'top-end',
          showConfirmButton: false
        });
        this.form.reset();
      },
      error: err => {
        console.error('Failed to create category:', err);
        Swal.fire({
          icon: 'error',
          title: 'Error',
          text: 'Could not create category.'
        });
      }
    });
  }
}
