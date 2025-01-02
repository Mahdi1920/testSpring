package tn.esprit.spring.testspringelmahdichabbouh.servicesImpl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.spring.testspringelmahdichabbouh.entites.*;
import tn.esprit.spring.testspringelmahdichabbouh.repositories.ArticleRepository;
import tn.esprit.spring.testspringelmahdichabbouh.repositories.CategoryRepository;
import tn.esprit.spring.testspringelmahdichabbouh.repositories.PersonneRepsitory;
import tn.esprit.spring.testspringelmahdichabbouh.servicesInterfaces.testServices;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
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

    @Override
    @Scheduled(cron = "*/10 * * * * *" )
    @Transactional
    public void afficherEtMettreAJourArticles() {
        for (Personne personne :personneRepo.findAll()){
            if(personne.getTypePersonne()==TypePersonne.ADMIN){
                for(Article article :personne.getArticlesList()){
                    article.setEtat(Etat.BOYCOTT);
                    log.info("Personne " + personne.getTypePersonne().toString()+ ", mail " + personne.getEmail() +" List articles : "+article.getNom());
                }
            }

        }
    }

    @Override
    public Article retrieveArticle(String nomArticle) {
        return articleRepo.findByNomLike(nomArticle);
    }

    @Override
    public Personne retrievePersonne(long id) {
       return personneRepo.findById(id).orElse(null);
    }

    @Override
    public Categorie ajouterCategorie(Categorie c) {
        return categoryRepo.save(c);
    }
}
