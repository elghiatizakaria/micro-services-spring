package ma.ac.emi.service_de_configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ServiceDeConfigurationApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceDeConfigurationApplication.class, args);
    }

}
