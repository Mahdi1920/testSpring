package tn.esprit.spring.testspringelmahdichabbouh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.testspringelmahdichabbouh.entites.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {
    Article findByNomLike(String nomArticle);

}
