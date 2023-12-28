package ma.ac.emi.services;


import ma.ac.emi.dto.InscriptionDTO;
import ma.ac.emi.response.CoursResponse;
import ma.ac.emi.response.EtudiantResponse;
import ma.ac.emi.response.InscriptionResponse;

import java.util.List;

public interface InscriptionOpenFeignService {

    InscriptionResponse createInscription(InscriptionDTO inscriptionDTO);
    List<InscriptionResponse> getAllInscriptions();
    InscriptionResponse getInscriptionById(Long id);
    InscriptionDTO updateInscription(Long id, InscriptionDTO updatedInscriptionDTO);
    void deleteInscription(Long id);
    List<CoursResponse> getAllCoursesByStudentId(Long id);
    List<EtudiantResponse> getAllStudentByCourseId(Long id);

}
