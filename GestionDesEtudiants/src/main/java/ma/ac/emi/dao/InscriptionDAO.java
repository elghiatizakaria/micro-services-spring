package ma.ac.emi.dao;

import ma.ac.emi.entities.Inscription;

import java.util.List;

public interface InscriptionDAO {

    List<Inscription> getAllInscriptions();

    Inscription getInscriptionById(Long id);

    Inscription createInscription(Inscription inscription);

    Inscription updateInscription(Long id, Inscription updatedInscription);

    void deleteInscription(Long id);
}