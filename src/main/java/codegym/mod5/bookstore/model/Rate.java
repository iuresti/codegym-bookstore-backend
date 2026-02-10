package codegym.mod5.bookstore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Rate {
    @Id
    private String id;
    private BigDecimal rate;
    private LocalDateTime fromDate;
    private LocalDateTime toDate;
    @Column(name = "book_id")
    private String bookId;
}
