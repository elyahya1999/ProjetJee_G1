package ma.emsi.springSecurity.config.service;

import ma.emsi.springSecurity.config.entities.AppRole;
import ma.emsi.springSecurity.config.entities.AppUser;

public interface SecurityService {
    AppUser saveNewUser(String username, String password,String confirmedPassword);
    AppRole saveNewRole(String roleName,String description);
    void addRoleToUser(String username,String roleName);
    void removeRoleFromUser(String username,String roleName);
    AppUser loadUserByUsername(String username);
}
