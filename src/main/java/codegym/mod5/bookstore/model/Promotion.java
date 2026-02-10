package codegym.mod5.bookstore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "promotions")
@Data
public class Promotion {
    @Id
    private String id;
    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean active;

}
