export interface CreateExpenseCommandModel {
  amount: number;
  description: string;
  date: string; // ISO date string
  categoryId: number;
}
