package codegym.mod5.bookstore.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "customers")
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("CUSTOMER")
public class Client extends User {

    private String firstName;
    private String lastName;

}
