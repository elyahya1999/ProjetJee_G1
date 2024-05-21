package ma.emsi.springSecurity.repositories;

import ma.emsi.springSecurity.entities.Employe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepo extends JpaRepository<Employe,Integer> {
    Page<Employe> findByNomContains(String kw,Pageable pageable);

}