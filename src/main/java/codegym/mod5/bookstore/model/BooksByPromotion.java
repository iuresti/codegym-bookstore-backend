package codegym.mod5.bookstore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "books_by_promotion")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BooksByPromotion {
    @Id
    private String id;
    @Column(name = "promotion_id")
    private String promotionId;
    @Column(name = "book_id")
    private String bookId;
}
