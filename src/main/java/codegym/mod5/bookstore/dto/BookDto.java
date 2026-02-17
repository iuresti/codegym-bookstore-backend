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
public class BookDto {
    private String id;
    private String title;
    private String author;
    private String genre;
    private BigDecimal price;
    private int stock;
    private String description;
    private String imageUrl;
    private float rating;
}
