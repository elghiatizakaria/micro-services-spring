package ma.ac.emi.etudiant;

import ma.ac.emi.etudiant.entities.Etudiant;
import ma.ac.emi.etudiant.repositories.EtudiantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class EtudiantApplication {

    public static void main(String[] args) {
        SpringApplication.run(EtudiantApplication.class, args);
    }

    @Bean
    CommandLineRunner start(EtudiantRepository etudiantRepository) {
        return args -> {
            String[] prenoms = {"Jean", "Marie", "Pierre", "Sophie", "Lucas",
                    "Camille", "Thomas", "Emma", "Louis", "Léa"};
            String[] noms = {"Martin", "Dubois", "Lefevre", "Leroy", "Moreau",
                    "Lefevre", "Simon", "Laurent", "Michel", "Roux"};


            for (int i = 0; i < prenoms.length; i++) {
                Etudiant etudiant = new Etudiant();
                etudiant.setNom(noms[i]);
                etudiant.setPrenom(prenoms[i]);
                etudiantRepository.save(etudiant);
            }
        };
    }

}
