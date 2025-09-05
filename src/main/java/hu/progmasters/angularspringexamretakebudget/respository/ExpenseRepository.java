package hu.progmasters.angularspringexamretakebudget.respository;

import hu.progmasters.angularspringexamretakebudget.domain.Expense;
import hu.progmasters.angularspringexamretakebudget.dto.outgoing.SummaryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    @Query("SELECT e.category.name, SUM(e.amount) FROM Expense e GROUP BY e.category.name ORDER BY e.category.name")
    List<Object[]> sumAmountsByCategory();

    List<Expense> findAllByOrderByDateDesc();
}