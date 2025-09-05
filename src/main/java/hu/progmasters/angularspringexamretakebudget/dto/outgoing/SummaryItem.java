package hu.progmasters.angularspringexamretakebudget.dto.outgoing;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SummaryItem {

    private Integer amount;
    private String categoryName;

}
