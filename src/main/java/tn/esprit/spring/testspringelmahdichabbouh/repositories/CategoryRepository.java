package tn.esprit.spring.testspringelmahdichabbouh.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.testspringelmahdichabbouh.entites.Categorie;

@Repository
public interface CategoryRepository extends CrudRepository<Categorie,Long>
{
}
