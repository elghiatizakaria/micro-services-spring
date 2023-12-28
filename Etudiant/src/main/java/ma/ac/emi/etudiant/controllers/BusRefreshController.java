package ma.ac.emi.etudiant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.bus.event.RefreshRemoteApplicationEvent;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.bus.BusProperties;
@RestController
public class BusRefreshController {

    @Autowired
    private BusProperties busProperties;

    @PostMapping("/busrefresh")
    public void busRefresh() {
        // Appel du /busrefresh pour actualiser la configuration
        System.out.println("Received bus refresh request");
        System.out.println("Destination: " + busProperties.getId());
    }
}




