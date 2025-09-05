package hu.progmasters.angularspringexamretakebudget.dto.outgoing;

import com.fasterxml.jackson.annotation.JsonFormat;
import hu.progmasters.angularspringexamretakebudget.domain.Expense;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseListItem {
    private Integer amount;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm[:ss]") // az utolsó :ss opcionális
    private LocalDateTime date;
    private String category;
    private String description;

    public ExpenseListItem(Expense expense) {
        this.amount = expense.getAmount();
        this.date = expense.getDate();
        this.category = expense.getCategory().getName();
        this.description = expense.getDescription();
    }

}
