package hu.progmasters.angularspringexamretakebudget.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "expense")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "amount")
    private Integer amount;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "description")
    private String description;

}