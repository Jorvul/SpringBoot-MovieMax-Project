package com.jorge.infosys.movies;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.jorge.infosys.movies.model.User;
import com.jorge.infosys.movies.service.RegistrationService;

@SpringBootApplication
@PropertySource(value = { "classpath:configuration.properties" })
public class InfyProjectMovieMaxApplication implements CommandLineRunner {
	
	@Autowired
	private Environment environment;
	@Autowired
	ApplicationContext context;

	public static void main(String[] args) {
		SpringApplication.run(InfyProjectMovieMaxApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		try {
			User user = new User();
			Scanner sc = new Scanner(System.in);
			System.out.println("**********************");
			  System.out.println("Welcome to MovieMax");
			System.out.println("**********************");
			System.out.println("Enter user id: ");
			String uid = sc.next();
			System.out.println("Enter name: ");
			String name = sc.next();
			System.out.println("Enter city: ");
			String city = sc.next();
			System.out.println("Enter email: ");
			String mail = sc.next();
			System.out.println("Enter phone: ");
			String phone = sc.next();
			System.out.println("Select a movie:");
			System.out.println("1.Spiderman");
			System.out.println("2.Thor");
			System.out.println("3.Logan");
			System.out.println("4.Conjuring 2");
			System.out.println("5.Star Wars");
			String movieSelection = sc.next();
			System.out.println("Select a theater:");
			System.out.println("- AMC");
			System.out.println("- Cobb Theaters");
			System.out.println("- Regal Cinemas");
			String theaterSelection = sc.next();
//			switch(movieSelection) {
//			case "one" :
//				System.out.println("Spiderman");
//				break;
//			case "two":
//				System.out.println("Thor");
//				break;
//			case "three":
//				System.out.println("Logan");
//				break;
//			case "four":
//				System.out.println("Conjuring 2");
//				break;
//			case "five":
//				System.out.println("Star Wars");
//				break;
//				default:
//					System.out.println("Invalid movie name");
//			}
			user.setCity(city);
			user.setUserId(uid);
			user.setName(name);
			user.setEmail(mail);
			user.setPhone(phone);
			user.setMovie(movieSelection);
			user.setTheater(theaterSelection);
			RegistrationService service = (RegistrationService) context.getBean("registrationService");
			String registrationMessage = service.registerUser(user);
			System.out.println(environment.getProperty(registrationMessage));
		} catch (Exception e) {
			System.out.println(environment.getProperty(e.getMessage()));
		}
	}
}
