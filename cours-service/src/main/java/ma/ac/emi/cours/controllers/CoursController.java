package ma.ac.emi.cours.controllers;

import ma.ac.emi.cours.entities.Cours;
import ma.ac.emi.cours.services.CoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cours")
public class CoursController {
    @Autowired
    private CoursService coursService;

    @GetMapping
    public List<Cours> getAllCourss() {
        return coursService.getAllCourss();
    }

    @GetMapping("/{id}")
    public Cours getCoursById(@PathVariable Long id) {
        return coursService.getCoursById(id);
    }

    @PostMapping
    public Cours createCours(@RequestBody Cours cours) {
        return coursService.createCours(cours);
    }

    @PutMapping("/{id}")
    public Cours updateCours(@PathVariable Long id, @RequestBody Cours updatedCours) {
        return coursService.updateCours(id, updatedCours);
    }

    @DeleteMapping("/{id}")
    public void deleteCours(@PathVariable Long id) {
        coursService.deleteCours(id);
    }
}
