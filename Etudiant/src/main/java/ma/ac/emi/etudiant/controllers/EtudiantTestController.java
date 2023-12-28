package ma.ac.emi.etudiant.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.endpoint.RefreshEndpoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Map;

@RestController
@RefreshScope
public class EtudiantTestController {
    @Value("${Genie}")
    private String Genie;

    @Value("${Option}")
    private String Option;

    private final RefreshEndpoint refreshEndpoint;

    public EtudiantTestController(RefreshEndpoint refreshEndpoint) {
        this.refreshEndpoint = refreshEndpoint;
    }

    @GetMapping("/myConfig")
    public Map<String, Object> configTest() {
        return Map.of("Genie", Genie, "Option", Option);
    }


}
