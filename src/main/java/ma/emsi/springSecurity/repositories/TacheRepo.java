package ma.emsi.springSecurity.repositories;

import ma.emsi.springSecurity.entities.Tache;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TacheRepo extends JpaRepository<Tache,Long>
{
    Page<Tache> findByNomContains(String keyword, PageRequest of);
}
