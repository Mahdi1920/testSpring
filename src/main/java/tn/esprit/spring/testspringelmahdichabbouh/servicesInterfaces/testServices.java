package tn.esprit.spring.testspringelmahdichabbouh.servicesInterfaces;

import tn.esprit.spring.testspringelmahdichabbouh.entites.Article;
import tn.esprit.spring.testspringelmahdichabbouh.entites.Personne;

public interface testServices {
    public Personne ajouterPersonne (Personne p);
    public Article ajouterArticleEtCategories (Article a);
    public void affecterArticleAPersonne(String nomArticle, String email);
    public boolean chercherArticle (String nomArticle);
}
