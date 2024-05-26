package ma.emsi.springSecurity.config.repositories;

import ma.emsi.springSecurity.config.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
    AppRole findByRoleName(String roleName);
}
