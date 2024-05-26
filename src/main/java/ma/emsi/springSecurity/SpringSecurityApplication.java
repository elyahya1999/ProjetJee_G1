package ma.emsi.springSecurity;

import ma.emsi.springSecurity.config.service.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}
	@Bean
	CommandLineRunner saveUsers(SecurityService securityService)
	{
		return args -> {
			securityService.saveNewUser("yahya","1234","1234");
			securityService.saveNewUser("jalal","1234","1234");
			securityService.saveNewUser("loubna","1234","1234");

			securityService.saveNewRole("ADMIN","Admin Role");
			securityService.saveNewRole("USER","User Role");

			securityService.addRoleToUser("yahya","ADMIN");
			securityService.addRoleToUser("yahya","USER");
			securityService.addRoleToUser("jalal","USER");
			securityService.addRoleToUser("loubna","USER");

		};
	}

	@Bean
	PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}

}
