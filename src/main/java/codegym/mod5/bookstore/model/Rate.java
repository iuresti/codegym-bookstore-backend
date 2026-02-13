package codegym.mod5.bookstore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Rate {
    @Id
    private String id;
    private BigDecimal rate;
    private LocalDateTime fromDate;
    private LocalDateTime toDate;
    @Column(name = "book_id")
    private String bookId;

    @CreatedDate
    @Column(name = "creation_date")
    private LocalDate creationDate;

    @LastModifiedDate
    @Column(name = "last_update_date")
    private LocalDate lastUpdateDate;
}
