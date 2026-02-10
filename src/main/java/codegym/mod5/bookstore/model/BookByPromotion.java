package codegym.mod5.bookstore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "books_by_promotion")
@Data
public class BookByPromotion {
    @Id
    private String id;

    @Column(name = "book_id")
    private String bookId;

    @Column(name = "promotion_id")
    private String promotionId;
}
