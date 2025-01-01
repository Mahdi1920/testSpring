package tn.esprit.spring.testspringelmahdichabbouh;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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
	@Mock
	private ArticleRepository articleRepo;
	@InjectMocks
	testImpl testService;

	Article article = Article.builder()
				.nom("a1")
				.etat(Etat.VERIF_EN_COUR)
				.build();
	Personne personne = Personne.builder()
			.email("e1")
			.dateInscri(LocalDate.now())
			.typePersonne(TypePersonne.ADMIN)
			.build();
	List<Personne> litPersonnes = new ArrayList<>() {
		{
			add(Personne.builder().email("e2").dateInscri(LocalDate.now()).typePersonne(TypePersonne.ADMIN).build());
			add(Personne.builder().email("e3").dateInscri(LocalDate.now()).typePersonne(TypePersonne.ADMIN).build());
		}
	};

	@Test
	public void testRetrievePersonne() {
		Mockito.when(personneRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(personne));
		Personne personne1 = testService.retrievePersonne(1);
		Assertions.assertNotNull(personne1);
	}
	@Test
	void testAjouterPersonne() {
		Mockito.when(personneRepository.save(Mockito.any(Personne.class))).thenReturn(personne);

		Personne savedPersonne = testService.ajouterPersonne(personne);

		 Assertions.assertNotNull(savedPersonne);
		Assertions.assertEquals("e1", savedPersonne.getEmail());
		Mockito.verify(personneRepository, Mockito.times(1)).save(personne);
	}

}
