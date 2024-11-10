package tn.esprit.spring.testspringelmahdichabbouh.entites;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    long id;
    String email;
    LocalDate dateInscri;
    @Enumerated(EnumType.STRING)
    TypePersonne typePersonne;
    @OneToMany
    List<Article> ArticlesList = new ArrayList<>();
}
