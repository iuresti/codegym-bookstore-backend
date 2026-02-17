package codegym.mod5.bookstore.dto;

import codegym.mod5.bookstore.model.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookOrderDto {

    private String id;

    private String userId;

    private String userName;

    private List<OrderItem> items;

    private BigDecimal total;

    private OrderStatus orderStatus;

    private LocalDateTime orderDate;

    private LocalDateTime completedDate;



    private LocalDateTime orderStartDate;


}
