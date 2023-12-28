package ma.ac.emi.controllers;


import ma.ac.emi.dto.CoursDTO;
import ma.ac.emi.dto.EtudiantDTO;
import ma.ac.emi.dto.InscriptionDTO;
import ma.ac.emi.entities.Inscription;
import ma.ac.emi.response.CoursResponse;
import ma.ac.emi.response.EtudiantResponse;
import ma.ac.emi.response.InscriptionResponse;
import ma.ac.emi.services.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/inscriptions")
public class InscriptionController {

    @Autowired
    private InscriptionService inscriptionService;

    @PostMapping
    public InscriptionResponse createInscription(@RequestBody InscriptionDTO inscriptionDTO) {
        return inscriptionService.createInscription(inscriptionDTO);
    }

    @GetMapping
    public List<InscriptionResponse> getAllInscriptions() {
        // Call InscriptionService to get all inscriptions
        return inscriptionService.getAllInscriptions();
    }

    @GetMapping("/{id}")
    public InscriptionResponse getInscriptionById(@PathVariable Long id) {
        // Call InscriptionService to get inscription by id
        return inscriptionService.getInscriptionById(id);
    }

    @PutMapping("/{id}")
    public InscriptionDTO updateInscription(@PathVariable Long id, @RequestBody InscriptionDTO updatedInscriptionDTO) {
        // Call InscriptionService to update inscription
        return inscriptionService.updateInscription(id, updatedInscriptionDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteInscription(@PathVariable Long id) {
        // Call InscriptionService to delete inscription
        inscriptionService.deleteInscription(id);
    }

    @GetMapping("/cours/du/etudiant/{id}")
    public List<CoursResponse> getAllCoursesByStudentId(@PathVariable Long id){
        return this.inscriptionService.getAllCoursesByStudentId(id);
    }
    @GetMapping("/etudiants/des/cours/{id}")
    public List<EtudiantResponse> getAllStudentByCourseId(@PathVariable Long id){
        return this.inscriptionService.getAllStudentByCourseId(id);
    }

}
