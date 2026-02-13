package codegym.mod5.bookstore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;

public class Sale {
    @Id
    private String id;


    @CreatedDate
    @Column(name = "creation_date")
    private LocalDate creationDate;

    @LastModifiedDate
    @Column(name = "last_update_date")
    private LocalDate lastUpdateDate;

}
