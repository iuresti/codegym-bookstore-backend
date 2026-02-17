package codegym.mod5.bookstore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "book_requests")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {
    @Id
    private String id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "book_title")
    private String bookTitle;

    private String author;

    private String genre;

    @Column(name = "request_date")
    private LocalDateTime requestDate;

    private BookRequestStatus status;

}
