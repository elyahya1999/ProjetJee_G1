package ma.emsi.springSecurity.repositories;

import jakarta.transaction.Transactional;
import ma.emsi.springSecurity.entities.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecRepo extends JpaRepository<Reclamation,Integer> {
}
