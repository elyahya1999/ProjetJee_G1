package ma.emsi.springSecurity.config.service;

import ma.emsi.springSecurity.config.entities.AppUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private SecurityService securityService;

    public UserDetailServiceImpl(SecurityService securityService) {
        this.securityService = securityService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = securityService.loadUserByUsername(username);
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        appUser.getAppRoles().forEach(r -> {
            SimpleGrantedAuthority authority=new SimpleGrantedAuthority(r.getRoleName());
            authorities.add(authority);
        });
        User springSecurityUser = new User(appUser.getUsername(), appUser.getPassword(), authorities);
        return springSecurityUser;
    }
}
