package mk.ukim.finki.labsemt.model.dto;

import lombok.Data;

@Data
public class AuthorDto {
    private String name;
    private String surname;
    private Long country;

    public AuthorDto() {
    }

}
