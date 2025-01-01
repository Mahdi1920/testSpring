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
import tn.esprit.spring.testspringelmahdichabbouh.repositories.ArticleRepository;
import tn.esprit.spring.testspringelmahdichabbouh.servicesImpl.testImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ArticleTest {
	@Mock
	ArticleRepository articleRepository;
	@InjectMocks
	testImpl articleService;
	Article article=Article.builder().nom("a1").etat(Etat.BOYCOTT).build();
	List<Article> listarticles = new ArrayList<Article>() {
		{
			add(Article.builder().nom("a2").etat(Etat.BOYCOTT).build());
			add(Article.builder().nom("a3").etat(Etat.VERIF_EN_COUR).build());
		}
	};

	@Test
	public void testRetrieveUser() {
		Mockito.when(articleRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(article));
		Article article1 = articleService.retrieveArticle("a1");
		Assertions.assertNotNull(article1);
	}
}
