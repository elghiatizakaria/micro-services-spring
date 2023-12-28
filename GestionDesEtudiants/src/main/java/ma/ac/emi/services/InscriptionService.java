package ma.ac.emi.services;

import ma.ac.emi.dto.CoursDTO;
import ma.ac.emi.dto.EtudiantDTO;
import ma.ac.emi.dto.InscriptionDTO;
import ma.ac.emi.entities.Inscription;
import ma.ac.emi.repositories.InscriptionRepository;
import ma.ac.emi.response.CoursResponse;
import ma.ac.emi.response.EtudiantResponse;
import ma.ac.emi.response.InscriptionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InscriptionService implements InscriptionOpenFeignService {
    @Autowired
    private InscriptionRepository inscriptionRepository;

    @Autowired
    private EtudiantFeignClient etudiantFeignClient;

    @Autowired
    private CoursFeignClient coursFeignClient;

    @Override
    public InscriptionResponse createInscription(InscriptionDTO inscriptionDTO) {
        EtudiantDTO etudiantDTO = etudiantFeignClient.getEtudiantById(inscriptionDTO.getEtudiantId());
        CoursDTO coursDTO = coursFeignClient.getCoursById(inscriptionDTO.getCoursId());

        Inscription inscription = new Inscription(etudiantDTO.getId(), coursDTO.getId());
        Inscription savedInscription = inscriptionRepository.save(inscription);
        InscriptionResponse inscriptionResponse = new InscriptionResponse(savedInscription.getId(), etudiantDTO.getId(), coursDTO.getId());
        return inscriptionResponse;
    }

    @Override
    public List<CoursResponse> getAllCoursesByStudentId(Long id) {
        List<CoursResponse> response = new ArrayList<>();
        List<Inscription> inscriptionList = inscriptionRepository.getInscriptionsByEtudiantId(id);
        for (Inscription inscription : inscriptionList) {
            CoursDTO cours = coursFeignClient.getCoursById(inscription.getCoursId());
            response.add(new CoursResponse(cours.getId(), cours.getLibelle(), cours.getDateCreation()));
        }
        return response;
    }

    @Override
    public List<EtudiantResponse> getAllStudentByCourseId(Long id) {
        List<EtudiantResponse> response = new ArrayList<>();
        List<Inscription> inscriptionList = inscriptionRepository.getInscriptionByCoursId(id);
        for (Inscription inscription : inscriptionList) {
            EtudiantDTO etudiant = etudiantFeignClient.getEtudiantById(inscription.getEtudiantId());
            response.add(new EtudiantResponse(etudiant.getId(), etudiant.getNom(), etudiant.getPrenom()));
        }
        return response;
    }

    @Override
    public List<InscriptionResponse> getAllInscriptions() {
        List<Inscription> inscriptions = inscriptionRepository.findAll();
        return inscriptions.stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public InscriptionResponse getInscriptionById(Long id) {
        return inscriptionRepository.findById(id)
                .map(this::convertToResponse)
                .orElse(null);
    }

    @Override
    public InscriptionDTO updateInscription(Long id, InscriptionDTO updatedInscriptionDTO) {
        return null;
    }

    @Override
    public void deleteInscription(Long id) {

    }


    private InscriptionResponse convertToResponse(Inscription inscription) {
        EtudiantDTO etudiantDTO = etudiantFeignClient.getEtudiantById(inscription.getEtudiantId());
        CoursDTO coursDTO = coursFeignClient.getCoursById(inscription.getCoursId());
        return new InscriptionResponse(inscription.getId(), etudiantDTO.getId(), coursDTO.getId());
    }
}
