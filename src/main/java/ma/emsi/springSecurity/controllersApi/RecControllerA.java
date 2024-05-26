package ma.emsi.springSecurity.controllersApi;

import ma.emsi.springSecurity.entities.Reclamation;
import ma.emsi.springSecurity.repositories.RecRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/reclamations")
public class RecControllerA {
    @Autowired
    RecRepo recRepo;

    @GetMapping
    public ResponseEntity<List<Reclamation>> getAllReclamations() {
        List<Reclamation> reclamations = recRepo.findAll();
        return ResponseEntity.ok(reclamations);
    }

    @PostMapping
    public ResponseEntity<Reclamation> createReclamation(@RequestBody Reclamation reclamation) {
        Reclamation savedReclamation = recRepo.save(reclamation);
        return ResponseEntity.ok(savedReclamation);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reclamation> getReclamation(@PathVariable Integer id) {
        Reclamation reclamation = recRepo.findById(id).orElse(null);
        if (reclamation == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(reclamation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reclamation> updateReclamation(@PathVariable Integer id, @RequestBody Reclamation reclamation) {
        Reclamation existingReclamation = recRepo.findById(id).orElse(null);
        if (existingReclamation == null) {
            return ResponseEntity.notFound().build();
        }
        reclamation.setId(existingReclamation.getId());
        Reclamation updatedReclamation = recRepo.save(reclamation);
        return ResponseEntity.ok(updatedReclamation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReclamation(@PathVariable Integer id) {
        recRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
