package ma.ac.emi.etudiant.dao;


import ma.ac.emi.etudiant.entities.Etudiant;

import java.util.List;

public interface EtudiantDAO {


    List<Etudiant> getAllEtudiants();

    Etudiant getEtudiantById(Long id);

    Etudiant createEtudiant(Etudiant student);

    Etudiant updateEtudiant(Long id, Etudiant updatedEtudiant);

    void deleteEtudiant(Long id);
}
