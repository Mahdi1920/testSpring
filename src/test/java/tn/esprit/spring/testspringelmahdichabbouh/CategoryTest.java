package tn.esprit.spring.testspringelmahdichabbouh;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.spring.testspringelmahdichabbouh.entites.Article;
import tn.esprit.spring.testspringelmahdichabbouh.entites.Categorie;
import tn.esprit.spring.testspringelmahdichabbouh.repositories.CategoryRepository;
import tn.esprit.spring.testspringelmahdichabbouh.servicesImpl.testImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@ExtendWith(MockitoExtension.class)
class CategoryTest {
	@Mock
	CategoryRepository categoryRepo;
	@InjectMocks
	 testImpl testService;
	Article article = Article.builder()
			.id(1)
			.nom("Test Article1")
			.build();

	Categorie categorie = Categorie.builder()
			.id(1)
			.nomCategorie("Test Category1")
			.articlesList(new ArrayList<>())
			.build();
	List<Categorie> litArticles = new ArrayList<>() {
		{
			add(Categorie.builder()
					.id(2)
					.nomCategorie("Test Category2")
					.articlesList(new ArrayList<>())
					.build());
			add(Categorie.builder().id(3)
					.nomCategorie("Test Category3")
					.articlesList(new ArrayList<>())
					.build());
		}
	};
	@Test
	void testSaveCategorie() {
		Mockito.when(categoryRepo.save(Mockito.any(Categorie.class))).thenReturn(categorie);

		Categorie savedCategorie = testService.ajouterCategorie(categorie);

		Assertions.assertNotNull(savedCategorie);
		Assertions.assertEquals("Test Category1", savedCategorie.getNomCategorie());
		Mockito.verify(categoryRepo, Mockito.times(1)).save(categorie);
	}

	@Test
	void testRetrieveCategorieById() {
		Mockito.when(categoryRepo.findById(1L)).thenReturn(Optional.of(categorie));

		Categorie retrievedCategorie = categoryRepo.findById(1L).orElse(null);

		Assertions.assertNotNull(retrievedCategorie);
		Assertions.assertEquals("Test Category1", retrievedCategorie.getNomCategorie());
		Mockito.verify(categoryRepo, Mockito.times(1)).findById(1L);
	}
}
