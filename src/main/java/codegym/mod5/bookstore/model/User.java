package codegym.mod5.bookstore.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorColumn(name = "user_type")
public class User {

    @Id
    private String id;

    private String email;

    private boolean active;

    @CreatedDate
    @Column(name = "creation_date")
    private LocalDate creationDate;

    @LastModifiedDate
    @Column(name = "last_update_date")
    private LocalDate lastUpdateDate;
}
