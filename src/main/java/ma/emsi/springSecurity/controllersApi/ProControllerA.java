package ma.emsi.springSecurity.controllersApi;

import ma.emsi.springSecurity.entities.Projet;
import ma.emsi.springSecurity.repositories.ProjetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/projets")
public class ProControllerA {
    @Autowired
    ProjetRepo projetRepo;

    @GetMapping
    public ResponseEntity<List<Projet>> getAllProjets() {
        List<Projet> projets = projetRepo.findAll();
        return ResponseEntity.ok(projets);
    }

    @PostMapping
    public ResponseEntity<Projet> createProjet(@RequestBody Projet projet) {
        Projet savedProjet = projetRepo.save(projet);
        return ResponseEntity.ok(savedProjet);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Projet> getProjet(@PathVariable Integer id) {
        Projet projet = projetRepo.findById(id).orElse(null);
        if (projet == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(projet);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Projet> updateProjet(@PathVariable Integer id, @RequestBody Projet projet) {
        Projet existingProjet = projetRepo.findById(id).orElse(null);
        if (existingProjet == null) {
            return ResponseEntity.notFound().build();
        }
        projet.setId(existingProjet.getId());
        Projet updatedProjet = projetRepo.save(projet);
        return ResponseEntity.ok(updatedProjet);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProjet(@PathVariable Integer id) {
        projetRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
