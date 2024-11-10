package tn.esprit.spring.testspringelmahdichabbouh.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.testspringelmahdichabbouh.entites.Personne;

@Repository
public interface PersonneRepsitory extends CrudRepository<Personne,Long> {
Personne findByEmailLike(String email);
}
