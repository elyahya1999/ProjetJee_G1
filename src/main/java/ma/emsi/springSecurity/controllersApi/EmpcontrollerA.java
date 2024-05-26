package ma.emsi.springSecurity.controllersApi;

import ma.emsi.springSecurity.entities.Employe;
import ma.emsi.springSecurity.repositories.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/employes")
public class EmpcontrollerA {
    @Autowired
    private EmpRepo emp;

    @GetMapping
    public ResponseEntity<Page<Employe>> getAllEmployes(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "3") int size,
            @RequestParam(name = "keyword", defaultValue = "") String keyword) {
        Page<Employe> pageEmployes = emp.findByNomContains(keyword, PageRequest.of(page, size));
        return ResponseEntity.ok(pageEmployes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmploye(@PathVariable Integer id) {
        emp.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Employe> createEmploye(@RequestBody Employe employe) {
        Employe savedEmploye = emp.save(employe);
        return ResponseEntity.ok(savedEmploye);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employe> getEmploye(@PathVariable Integer id) {
        Employe employe = emp.findById(id).orElse(null);
        if (employe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employe);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employe> updateEmploye(@PathVariable Integer id, @RequestBody Employe employe) {
        Employe existingEmploye = emp.findById(id).orElse(null);
        if (existingEmploye == null) {
            return ResponseEntity.notFound().build();
        }
        employe.setId(existingEmploye.getId());
        Employe updatedEmploye = emp.save(employe);
        return ResponseEntity.ok(updatedEmploye);
    }
}
