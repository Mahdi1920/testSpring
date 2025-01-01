package tn.esprit.spring.testspringelmahdichabbouh;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.spring.testspringelmahdichabbouh.entites.Article;
import tn.esprit.spring.testspringelmahdichabbouh.entites.Etat;
import tn.esprit.spring.testspringelmahdichabbouh.entites.Personne;
import tn.esprit.spring.testspringelmahdichabbouh.entites.TypePersonne;
import tn.esprit.spring.testspringelmahdichabbouh.repositories.ArticleRepository;
import tn.esprit.spring.testspringelmahdichabbouh.repositories.PersonneRepsitory;
import tn.esprit.spring.testspringelmahdichabbouh.servicesImpl.testImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ArticleTest {
	@Mock
	PersonneRepsitory personneRepository;
	@InjectMocks
	testImpl articleService;
	Personne personne = Personne.builder().email("e1").dateInscri(LocalDate.now()).typePersonne(TypePersonne.ADMIN).build();
	List<Personne> litPersonnes = new ArrayList<>() {
		{
			add(Personne.builder().email("e2").dateInscri(LocalDate.now()).typePersonne(TypePersonne.ADMIN).build());
			add(Personne.builder().email("e3").dateInscri(LocalDate.now()).typePersonne(TypePersonne.ADMIN).build());
		}
	};

	@Test
	public void testRetrieveUser() {
		Mockito.when(personneRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(personne));
		Personne personne1 = articleService.retrievePersonne(1);
		Assertions.assertNotNull(personne1);
	}
}
