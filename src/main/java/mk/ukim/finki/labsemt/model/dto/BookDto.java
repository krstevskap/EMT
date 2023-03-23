package mk.ukim.finki.labsemt.model.dto;

import lombok.Data;
import mk.ukim.finki.labsemt.model.enumerations.Category;

@Data
public class BookDto {
    private String name;
    private Category category;
    private Long author;
    private Integer availableCopies;
}
