import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './componentes/navbar/navbar.component';
import { ExpenseListComponent } from './componentes/expense-list/expense-list.component';
import { ExpenseFormComponent } from './componentes/expense-form/expense-form.component';
import { CategoryFormComponent } from './componentes/category-form/category-form.component';
import { CategoryListComponent } from './componentes/category-list/category-list.component';
import { SummaryComponent } from './componentes/summary/summary.component';
import {HttpClientModule} from '@angular/common/http';
import {ReactiveFormsModule} from '@angular/forms';
import {BaseChartDirective} from 'ng2-charts';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    ExpenseListComponent,
    ExpenseFormComponent,
    CategoryFormComponent,
    CategoryListComponent,
    SummaryComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    BaseChartDirective

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
