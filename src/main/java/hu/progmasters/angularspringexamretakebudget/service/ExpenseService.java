package hu.progmasters.angularspringexamretakebudget.service;

import hu.progmasters.angularspringexamretakebudget.domain.Category;
import hu.progmasters.angularspringexamretakebudget.domain.Expense;
import hu.progmasters.angularspringexamretakebudget.dto.incoming.CreateExpenseCommand;
import hu.progmasters.angularspringexamretakebudget.dto.outgoing.ExpenseListItem;
import hu.progmasters.angularspringexamretakebudget.dto.outgoing.SummaryItem;
import hu.progmasters.angularspringexamretakebudget.respository.CategoryRepository;
import hu.progmasters.angularspringexamretakebudget.respository.ExpenseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public ExpenseService(ExpenseRepository expenseRepository, CategoryRepository categoryRepository) {
        this.expenseRepository = expenseRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<ExpenseListItem> fetchAllExpenses() {
        return expenseRepository.findAllByOrderByDateDesc().stream()
                .map(ExpenseListItem::new)
                .toList();
    }

    public List<SummaryItem> fetchBudgetSummary() {
        return expenseRepository.sumAmountsByCategory().stream()
                .map(row -> {
                    String categoryName = (String) row[0];
                    Integer amount = ((Number) row[1]).intValue();
                    return new SummaryItem(amount, categoryName);
                })
                .toList();
    }

    public void createExpense(CreateExpenseCommand command) {
        Category category = categoryRepository.findById(command.getCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("Category not found: " + command.getCategoryId()));

        Expense expense = new Expense();
        expense.setAmount(command.getAmount());
        expense.setDescription(command.getDescription());
        expense.setDate(command.getDate());
        expense.setCategory(category);

        expenseRepository.save(expense);
    }
}
