package com.enset;

import com.enset.entites.Role;
import com.enset.entites.User;
import com.enset.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class JpaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	/*@Bean
	CommandLineRunner start(UserService userService){
		return args -> {
			User u = new User();
			u.setUserName("user1");
			u.setPassword("12345");
			userService.addNewUser(u);
			User u2 = new User();
			u.setUserName("admin");
			u.setPassword("123456");
			userService.addNewUser(u2);

			Stream.of("STUDENT", "USER", "ADMIN").forEach(r->{
				Role r1 = new Role();
				r1.setRoleName(r);
				userService.addNewRole(r1);
			});

			userService.addRoleToUser("user1","STUDENT");
			userService.addRoleToUser("user1","USER");
			userService.addRoleToUser("admin","ADMIN");
			userService.addRoleToUser("admin","USER");
		};
	}*/
}
