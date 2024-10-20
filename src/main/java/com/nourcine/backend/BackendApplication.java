package com.nourcine.backend;

import com.nourcine.backend.auth.AuthenticationService;
import com.nourcine.backend.auth.RegisterRequest;
import com.nourcine.backend.user.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import static com.nourcine.backend.user.Role.Admin;


@SpringBootApplication

public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(
//			AuthenticationService service
//	){
//		return args -> {
//			var admin = RegisterRequest.builder()
//					.firstname("Admin")
//					.lastname("Admin")
//					.email("admin@mail.com")
//					.password("password")
//					.role(ADMIN)
//					.build();
//			System.out.println("Admin token: " + service.register(admin).getAccessToken());
//			var manager = RegisterRequest.builder()
//					.firstname("Manger")
//					.lastname("Manger")
//					.email("manger@mail.com")
//					.password("password")
//					.role(MANAGER)
//					.build();
//			System.out.println("Manger token: " + service.register(manager).getAccessToken());
//
//		};
//	}
//        @Bean
//    public CommandLineRunner commandLineRunner(AuthenticationService service){
//        return args -> {
//            String adminEmail = "admin@gmail.com";
//            if (!service.existsByEmail(adminEmail)) {
//                var admin = RegisterRequest.builder()
//                        .firstname("Admin")
//                        .lastname("Admin")
//                        .email(adminEmail)
//                        .password("password")
//
//                        .role(Admin)
//                        .build();
//                System.out.println("Admin token: " + service.register(admin));
//            } else {
//                System.out.println("Existing admin token: " + service.getTokenForExistingUser(adminEmail));
//            }
//        };
//    }

}

