package hu.progmasters.angularspringexamretakebudget.dto.outgoing;

import hu.progmasters.angularspringexamretakebudget.domain.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryListItem {

    private Long id;
    private String name;

    public CategoryListItem(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }
}
