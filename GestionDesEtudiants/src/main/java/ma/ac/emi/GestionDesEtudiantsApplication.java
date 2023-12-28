package ma.ac.emi;

import ma.ac.emi.dto.CoursDTO;
import ma.ac.emi.dto.EtudiantDTO;
import ma.ac.emi.entities.Inscription;
import ma.ac.emi.repositories.InscriptionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients(basePackages = "ma.ac.emi.services")
@ImportAutoConfiguration({FeignAutoConfiguration.class})
public class GestionDesEtudiantsApplication {



    public static void main(String[] args) {
        SpringApplication.run(GestionDesEtudiantsApplication.class, args);
    }

    @Bean
    public CommandLineRunner start(
            InscriptionRepository inscriptionRepository,
            WebClient.Builder webClientBuilder
    ) {
        return args -> {
            EtudiantDTO etudiantDTO = getEtudiantDetails(webClientBuilder, 1L);
            CoursDTO coursDTO = getCoursDetails(webClientBuilder, 1L);

            // Créez une nouvelle inscription
            Inscription inscription = new Inscription();
            inscription.setEtudiantId(etudiantDTO.getId());
            inscription.setCoursId(coursDTO.getId());
            System.out.println("etudiantDTO:" + etudiantDTO);
            System.out.println("coursDTO:" + coursDTO);

            // Enregistrez l'inscription dans la base de données
            inscriptionRepository.save(inscription);
        };
    }

    private EtudiantDTO getEtudiantDetails(WebClient.Builder webClientBuilder, Long etudiantId) {
        return webClientBuilder
                .build()
                .get()
                .uri("http://localhost:8082/etudiants/1", etudiantId)
                .retrieve()
                .bodyToMono(EtudiantDTO.class)
                .block();
    }

    private CoursDTO getCoursDetails(WebClient.Builder webClientBuilder, Long coursId) {
        return webClientBuilder
                .build()
                .get()
                .uri("http://localhost:8081/cours/2", coursId)
                .retrieve()
                .bodyToMono(CoursDTO.class)
                .block();
    }

}
