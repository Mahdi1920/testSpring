package tn.esprit.spring.testspringelmahdichabbouh.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.testspringelmahdichabbouh.entites.Article;
import tn.esprit.spring.testspringelmahdichabbouh.entites.Personne;
import tn.esprit.spring.testspringelmahdichabbouh.entites.TypePersonne;
import tn.esprit.spring.testspringelmahdichabbouh.servicesInterfaces.testServices;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/test")
@AllArgsConstructor
public class testControllers {
    testServices service;
    @PostMapping("/personne/addPersonne")
    public Personne ajouterPersonne(@RequestBody Personne p) {
        return service.ajouterPersonne(p);
    }
    @PostMapping("/article/addArticle")
    public Article ajouterArticleEtCategories(@RequestBody Article a) {
        return service.ajouterArticleEtCategories(a);
    }
    @PutMapping("/article/addArticlepersonne/{nomArticle}/{email}")
    public void affecterArticleAPersonne(@PathVariable String nomArticle, @PathVariable String email) {
        service.affecterArticleAPersonne(nomArticle, email);
    }
    @GetMapping("/article/chercherArticle/{nomArticle}")
    public boolean chercherArticle(String nomArticle) {
        return service.chercherArticle(nomArticle);
    }
    @GetMapping("/personne/recupererPersonnessParCriteres/{nomCategorie}/{d}/{tp}")
    public List<Personne> recupererPersonnessParCriteres(@PathVariable String  nomCategorie, @PathVariable LocalDate d, @PathVariable TypePersonne tp) {
        return service.recupererPersonnessParCriteres(nomCategorie, d, tp);
    }
}
