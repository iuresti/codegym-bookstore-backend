package codegym.mod5.bookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
    private String bookId;
    private String title;
    private BigDecimal price;
    private int quantity;
}
