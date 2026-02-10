package codegym.mod5.bookstore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "books")
@Data
public class Book {
    @Id
    private String id;

    private String isbn;
    private String title;
    private String author;
    
    
}
