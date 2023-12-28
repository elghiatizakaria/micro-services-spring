package ma.ac.emi.cours.dao;


import ma.ac.emi.cours.entities.Cours;

import java.util.List;

public interface CoursDAO {


    List<Cours> getAllCourss();

    Cours getCoursById(Long id);

    Cours createCours(Cours student);

    Cours updateCours(Long id, Cours updatedCours);

    void deleteCours(Long id);
}
