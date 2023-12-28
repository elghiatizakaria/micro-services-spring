package ma.ac.emi.cours.services;

import ma.ac.emi.cours.dao.CoursDAO;
import ma.ac.emi.cours.entities.Cours;
import ma.ac.emi.cours.repositories.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CoursService implements CoursDAO {
    @Autowired
    private CoursRepository coursRepository;

    @Override
    public List<Cours> getAllCourss() {
        return coursRepository.findAll();
    }

    @Override
    public Cours getCoursById(Long id) {
        return coursRepository.findById(id).orElse(null);
    }

    @Override
    public Cours createCours(Cours cours) {
        return coursRepository.save(cours);
    }

    @Override
    public Cours updateCours(Long id, Cours updatedCours) {
        Cours existingCours = coursRepository.findById(id).orElse(null);
        if (existingCours != null) {
            existingCours.setLibelle(updatedCours.getLibelle());
            existingCours.setDateCreation(updatedCours.getDateCreation());
            return coursRepository.save(existingCours);
        }
        return null;
    }

    @Override
    public void deleteCours(Long id) {
        coursRepository.deleteById(id);
    }
}
