package codegym.mod5.bookstore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class ShoppingCart {
    @Id
    private String id;

    @Column(name = "user_id")
    private String userId;

}
