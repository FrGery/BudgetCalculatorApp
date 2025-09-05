package hu.progmasters.angularspringexamretakebudget.dto.incoming;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCategoryCommand {
    private String name;

}
