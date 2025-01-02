package tn.esprit.spring.testspringelmahdichabbouh.servicesInterfaces;

import tn.esprit.spring.testspringelmahdichabbouh.entites.Article;
import tn.esprit.spring.testspringelmahdichabbouh.entites.Categorie;
import tn.esprit.spring.testspringelmahdichabbouh.entites.Personne;
import tn.esprit.spring.testspringelmahdichabbouh.entites.TypePersonne;

import java.time.LocalDate;
import java.util.List;

public interface testServices {
    public Personne ajouterPersonne (Personne p);
    public Article ajouterArticleEtCategories (Article a);
    public void affecterArticleAPersonne(String nomArticle, String email);
    public boolean chercherArticle (String nomArticle);
    public List<Personne> recupererPersonnessParCriteres(String nomCategorie, LocalDate d, TypePersonne tp);
    public void afficherEtMettreAJourArticles ();
    public Article retrieveArticle(String nomArticle);
    public Personne retrievePersonne(long id);

    public Categorie ajouterCategorie(Categorie c);
}
