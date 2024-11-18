package tn.esprit.spring.testspringelmahdichabbouh.servicesImpl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.testspringelmahdichabbouh.entites.Article;
import tn.esprit.spring.testspringelmahdichabbouh.entites.Personne;
import tn.esprit.spring.testspringelmahdichabbouh.entites.TypePersonne;
import tn.esprit.spring.testspringelmahdichabbouh.repositories.ArticleRepository;
import tn.esprit.spring.testspringelmahdichabbouh.repositories.CategoryRepository;
import tn.esprit.spring.testspringelmahdichabbouh.repositories.PersonneRepsitory;
import tn.esprit.spring.testspringelmahdichabbouh.servicesInterfaces.testServices;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class testImpl implements testServices {
    ArticleRepository articleRepo;
    CategoryRepository categoryRepo;
    PersonneRepsitory personneRepo;
    @Override
    public Personne ajouterPersonne(Personne p) {
        return personneRepo.save(p);
    }

    @Override
    public Article ajouterArticleEtCategories(Article a) {
        return articleRepo.save(a);
    }

    @Override
    public void affecterArticleAPersonne(String nomArticle, String email) {
        Personne personne=personneRepo.findByEmailLike(email);
        Article article =articleRepo.findByNomLike(nomArticle);
        personne.getArticlesList().add(article);
        personneRepo.save(personne);
    }

    @Override
    public boolean chercherArticle(String nomArticle) {
        Article article =articleRepo.findByNomLike(nomArticle);
        return article.getEtat().toString().equals("BOYCOTT");
    }

    @Override
    public List<Personne> recupererPersonnessParCriteres(String nomCategorie, LocalDate d, TypePersonne tp) {
       List<Personne>  personnes = personneRepo.findByArticlesListCategoriesListNomCategorieLikeAndDateInscriGreaterThanAndTypePersonneLike(nomCategorie, d, tp);
        return personnes;
    }
}
