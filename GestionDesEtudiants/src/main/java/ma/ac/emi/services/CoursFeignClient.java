package ma.ac.emi.services;

import ma.ac.emi.dto.CoursDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Service
@FeignClient(name = "cours-service", url = "http://localhost:8081")
public interface CoursFeignClient {
    @GetMapping("/cours/{id}")
    CoursDTO getCoursById(@PathVariable Long id);
}

