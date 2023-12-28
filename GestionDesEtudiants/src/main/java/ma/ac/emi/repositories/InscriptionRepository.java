package ma.ac.emi.repositories;

import ma.ac.emi.entities.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface InscriptionRepository extends JpaRepository<Inscription,Long> {
    List<Inscription> getInscriptionsByEtudiantId(Long id);
    List<Inscription> getInscriptionByCoursId(Long id);
}
