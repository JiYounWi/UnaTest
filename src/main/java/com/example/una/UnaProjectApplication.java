package com.example.una;

import com.example.una.user.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//@SpringBootApplication
//public class UnaProjectApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(UnaProjectApplication.class, args);
//	}
//
//}
@SpringBootApplication
public class UnaProjectApplication {

	private final UserService userService;

	public UnaProjectApplication(UserService userService) {
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(UnaProjectApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo() {
		return (args) -> {
			// 사용자 저장 예시
			userService.saveUser("John Doe", "john@example.com");
			userService.saveUser("Jane Smith", "jane@example.com");
			userService.saveUser("위지윤","wi49325@gmail.com");
		};
	}
}