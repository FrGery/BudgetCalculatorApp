package hu.progmasters.angularspringexamretakebudget.controller;

import hu.progmasters.angularspringexamretakebudget.dto.incoming.CreateCategoryCommand;
import hu.progmasters.angularspringexamretakebudget.dto.incoming.CreateExpenseCommand;
import hu.progmasters.angularspringexamretakebudget.dto.outgoing.CategoryListItem;
import hu.progmasters.angularspringexamretakebudget.dto.outgoing.ExpenseListItem;
import hu.progmasters.angularspringexamretakebudget.dto.outgoing.SummaryItem;
import hu.progmasters.angularspringexamretakebudget.service.CategoryService;
import hu.progmasters.angularspringexamretakebudget.service.ExpenseService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/budgets")
@Slf4j
public class BudgetController {

    private final ExpenseService expenseService;
    private final CategoryService categoryService;

    public BudgetController(ExpenseService expenseService, CategoryService categoryService) {
        this.expenseService = expenseService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<ExpenseListItem>> getAllBudgets() {
        log.info("Fetching all expenses");
        return new ResponseEntity<>(expenseService.fetchAllExpenses(), HttpStatus.OK);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryListItem>> getAllCategories() {
        log.info("Fetching all categories");
        return new ResponseEntity<>(categoryService.fetchAllCategories(), HttpStatus.OK);
    }

    @GetMapping("/summary")
    public ResponseEntity<List<SummaryItem>> getSummary() {
        log.info("Fetching budget summary");
        return new ResponseEntity<>(expenseService.fetchBudgetSummary(), HttpStatus.OK);
    }

    @PostMapping("/categories")
    public ResponseEntity<Void> createCategory(@RequestBody @Valid CreateCategoryCommand command) {
        categoryService.createCategory(command);
        log.info("Category created with name: {}", command.getName());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/expenses")
    public ResponseEntity<Void> createExpense(@RequestBody @Valid CreateExpenseCommand command) {
        expenseService.createExpense(command);
        log.info("Expense created with description: {}", command);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

