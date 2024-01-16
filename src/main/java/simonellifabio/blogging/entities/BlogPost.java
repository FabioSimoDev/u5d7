package simonellifabio.blogging.entities;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BlogPost {
    UUID id;
    String category;
    String title;
    String cover;
    String content;
    int readTime;
}
