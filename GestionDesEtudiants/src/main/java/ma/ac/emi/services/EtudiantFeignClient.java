package ma.ac.emi.services;

import ma.ac.emi.dto.EtudiantDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@FeignClient(name = "etudiant-service", url = "http://localhost:8082") // Ajoutez l'URL de base du service
public interface EtudiantFeignClient {

    @GetMapping("/etudiants/{id}") // Ajoutez le chemin correct pour l'API d'étudiant
    EtudiantDTO getEtudiantById(@PathVariable Long id);
}