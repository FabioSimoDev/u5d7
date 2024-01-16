package simonellifabio.blogging.entities;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PostAuthor {
    UUID id;
    String name;
    String surname;
    String email;
    LocalDate dateOfBirth;
    String avatar;
}
