package codegym.mod5.bookstore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;

@Entity
@Table(name = "reviews")
@Data
public class Review {
    @Id
    private String id;

    @Column(name = "book_id")
    private String bookId;

    @Column(name = "user_id")
    private String userId;

    private String review;

    @CreatedDate
    @Column(name = "creation_date")
    private LocalDate creationDate;

    @LastModifiedDate
    @Column(name = "last_update_date")
    private LocalDate lastUpdateDate;

}
