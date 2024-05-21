package ma.emsi.springSecurity.repositories;

import jakarta.transaction.Transactional;
import ma.emsi.springSecurity.entities.Projet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetRepo extends JpaRepository<Projet,Integer> {
}
