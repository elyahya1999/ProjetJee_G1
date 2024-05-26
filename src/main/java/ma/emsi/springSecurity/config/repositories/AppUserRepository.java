package ma.emsi.springSecurity.config.repositories;

import ma.emsi.springSecurity.config.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, String> {
    AppUser findByUsername(String username);
}
