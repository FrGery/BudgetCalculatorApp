import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ExpenseListComponent} from './componentes/expense-list/expense-list.component';
import {ExpenseFormComponent} from './componentes/expense-form/expense-form.component';
import {CategoryListComponent} from './componentes/category-list/category-list.component';
import {CategoryFormComponent} from './componentes/category-form/category-form.component';
import {SummaryComponent} from './componentes/summary/summary.component';

const routes: Routes = [
  {path: '', component: ExpenseListComponent},
  {path: 'budgets', component: ExpenseListComponent},
  {path: 'expenses-form', component: ExpenseFormComponent},
  {path: 'categories', component: CategoryListComponent},
  {path: 'categories-form', component: CategoryFormComponent},
  {path: 'summary', component: SummaryComponent},
  {path: '**', redirectTo: ''},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
