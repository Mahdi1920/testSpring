package tn.esprit.spring.testspringelmahdichabbouh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.testspringelmahdichabbouh.entites.Article;
import tn.esprit.spring.testspringelmahdichabbouh.entites.Personne;
import tn.esprit.spring.testspringelmahdichabbouh.entites.TypePersonne;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PersonneRepsitory extends JpaRepository<Personne,Long> {
Personne findByEmailLike(String email);
List<Personne> findByArticlesListCategoriesListNomCategorieLikeAndDateInscriGreaterThanAndTypePersonneLike(String nomCategorie, LocalDate d, TypePersonne tp);
//List<Personne> findByCategorieNomCategorieAndCategorieArticleListAndDdateInscriGreaterThanAndTypePersonneLike(String nomCategorie, LocalDate d, TypePersonne tp);
List<Personne> findByTypePersonne(TypePersonne type);
}
