package codegym.mod5.bookstore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "books_by_order")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BooksByOrder {
    @Id
    private String id;

    @Column(name = "book_id")
    private String bookId;

    @Column(name = "order_id")
    private String orderId;

    private BigDecimal price;

    private int quantity;
}
