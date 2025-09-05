package hu.progmasters.angularspringexamretakebudget.dto.incoming;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateExpenseCommand {
    private Integer amount;
    private String description;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm[:ss]") // az utolsó :ss opcionális
    private LocalDateTime date;
    private Long categoryId;


}

