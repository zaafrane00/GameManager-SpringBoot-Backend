package com.tunisoft.Tunisoft;

import com.tunisoft.Tunisoft.role.Role;
import com.tunisoft.Tunisoft.user.User;
import com.tunisoft.Tunisoft.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class TunisoftApplication {
	private final String ROLE_USER="ROLE_USER";
	private final String ROLE_MANAGER="ROLE_MANAGER";
	private final String ROLE_ADMIN="ROLE_ADMIN";
	private final String ROLE_SUPERADMIN="ROLE_SUPERADMIN";
	private final String HAMZA4="hamza4@gmail.com";


	public static void main(String[] args) {
		SpringApplication.run(TunisoftApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args ->{
			userService.saveRole(new Role(null,ROLE_USER));
			userService.saveRole(new Role(null,ROLE_MANAGER));
			userService.saveRole(new Role(null,ROLE_ADMIN));
			userService.saveRole(new Role(null,ROLE_SUPERADMIN));

			userService.saveUser(new User(null,"Hamza","Zaafrane","hamza@gmail.com","123456789",new ArrayList<>()));
			userService.saveUser(new User(null,"Hamza2","Zaafrane2","hamza2@gmail.com","123456789",new ArrayList<>()));
			userService.saveUser(new User(null,"Hamza3","Zaafrane3","hamza3@gmail.com","123456789",new ArrayList<>()));
			userService.saveUser(new User(null,"Hamza4","Zaafrane4","hamza4@gmail.com","123456789",new ArrayList<>()));

			userService.addRoleToUser("hamza@gmail.com",ROLE_SUPERADMIN);
			userService.addRoleToUser("hamza2@gmail.com",ROLE_ADMIN);
			userService.addRoleToUser("hamza3@gmail.com",ROLE_MANAGER);
			userService.addRoleToUser(HAMZA4,ROLE_USER);
			userService.addRoleToUser(HAMZA4,ROLE_MANAGER);
		};


	}

}
