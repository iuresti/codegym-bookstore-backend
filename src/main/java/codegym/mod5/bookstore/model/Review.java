package codegym.mod5.bookstore.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "reviews")
@Data
public class Review {
    @Id
    private String id;

    @Column(name = "book_id")
    private String bookId;

    private String review;

    @UpdateTimestamp
    private LocalDate lastUpdateDate;

}
