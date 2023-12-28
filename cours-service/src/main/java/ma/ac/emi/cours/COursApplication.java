package ma.ac.emi.cours;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

@EnableDiscoveryClient
@SpringBootApplication
public class COursApplication {
 public static void main(String[] args) {
        SpringApplication.run(COursApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ma.ac.emi.cours.repositories.CoursRepository coursRepository) {
        return args -> {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            // Noms de cours réels
            String[] coursNames = {
                    "Mathématiques avancées",
                    "Programmation Java",
                    "Introduction à l'intelligence artificielle",
                    "Chimie organique",
                    "Analyse de données",
                    "Systèmes distribués",
                    "Philosophie politique",
                    "Économie mondiale",
                    "Conception de bases de données",
                    "Théorie des jeux"
            };

            // Remplir la base de données avec des cours
            for (String coursName : coursNames) {
                ma.ac.emi.cours.entities.Cours cours = new ma.ac.emi.cours.entities.Cours();
                cours.setLibelle(coursName);
                cours.setDateCreation(generateRandomDate());
                coursRepository.save(cours);
            }
        };
    }

    private Date generateRandomDate() {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            long startMillis = dateFormat.parse("2020-01-01").getTime();
            long endMillis = System.currentTimeMillis();
            long randomMillisSinceEpoch = ThreadLocalRandom.current().nextLong(startMillis, endMillis);
            return new Date(randomMillisSinceEpoch);
        } catch (ParseException e) {
            e.printStackTrace();
            return new Date(); // Return current date in case of error
        }
    }

}
