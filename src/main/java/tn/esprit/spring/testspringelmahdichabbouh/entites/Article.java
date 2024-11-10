package tn.esprit.spring.testspringelmahdichabbouh.entites;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

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
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    long id ;
    String nom;
    @Enumerated(EnumType.STRING)
    Etat etat;

    @ManyToMany(cascade =CascadeType.ALL)
    List<Categorie> categoriesList = new ArrayList<>();
}
