package com.jorge.infosys.movies.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//import com.jorge.infosys.irs.repository.UserRepository;
import com.jorge.infosys.movies.entity.UserEntity;
import com.jorge.infosys.movies.exception.InfyMovieMaxException;
import com.jorge.infosys.movies.exception.InvalidCityException;
import com.jorge.infosys.movies.exception.InvalidEmailException;
import com.jorge.infosys.movies.exception.InvalidMovieException;
import com.jorge.infosys.movies.exception.InvalidNameException;
import com.jorge.infosys.movies.exception.InvalidPhoneException;
import com.jorge.infosys.movies.exception.InvalidUserIdException;
import com.jorge.infosys.movies.exception.UserIdAlreadyPresentException;
//import com.jorge.infosys.movies.exception.InfyGoBootException;
//import com.jorge.infosys.movies.exception.InvalidCityException;
//import com.jorge.infosys.movies.exception.InvalidEmailException;
//import com.jorge.infosys.movies.exception.InvalidNameException;
//import com.jorge.infosys.movies.exception.InvalidPasswordException;
//import com.jorge.infosys.movies.exception.InvalidPhoneException;
//import com.jorge.infosys.movies.exception.InvalidUserIdException;
//import com.jorge.infosys.movies.exception.UserIdAlreadyPresentException;
import com.jorge.infosys.movies.model.User;
//import com.jorge.infosys.movies.repository.UserRepository;
import com.jorge.infosys.movies.repository.UserRepository;

@Service
public class RegistrationService {

	@Autowired
	private UserRepository userRepository;
	String regex1 = "^[a-zA-Z0-9]{4,15}+$";
	public String registerUser(User user) throws InfyMovieMaxException {
		validateUser(user);
		boolean b = userRepository.existsById(user.getUserId());
		if (b)
			throw new UserIdAlreadyPresentException("RegistrationService.USERID_PRESENT");
		UserEntity userEntity = new UserEntity();
		userEntity.setCity(user.getCity());
		userEntity.setEmail(user.getEmail());
		userEntity.setName(user.getName());
		userEntity.setPhone(user.getPhone());
		userEntity.setUserId(user.getUserId());
		userEntity.setMovie(user.getMovie());
		userEntity.setTheater(user.getTheater());
		userRepository.saveAndFlush(userEntity);
		return "UserRespository.REGISTRATION_SUCCESS";
	}
	public void validateUser(User user) throws InfyMovieMaxException {
		if (!isValidUserId(user.getUserId()))
			throw new InvalidUserIdException("RegistrationService.INVALID_USER_ID");
		if (!isValidName(user.getName()))
			throw new InvalidNameException("RegistrationService.INVALID_NAME");
		if (!isValidCity(user.getCity()))
			throw new InvalidCityException("RegistrationService.INVALID_CITY");
		if (!isValidEmail(user.getEmail()))
			throw new InvalidEmailException("RegistrationService.INVALID_EMAIL");
		if (!isValidPhoneNumber(user.getPhone()))
			throw new InvalidPhoneException("RegistrationService.INVALID_PHONE_NUMBER");
		if (!isValidMovie(user.getMovie()))
			throw new InvalidMovieException("Registration.Service.INVALID_MOVIE");
		if (!isValidTheater(user.getTheater()))
			throw new InvalidMovieException("Registration.Service.INVALID_THEATER");
	}
	public Boolean isValidUserId(String userid) {
		Boolean b1 = false;
		Pattern pattern1 = Pattern.compile(regex1);
		Matcher matcher1 = pattern1.matcher(userid);
		if (matcher1.matches())
			b1 = true;
		return b1;
	}
	
	public Boolean isValidName(String name) {
		Boolean b1 = false;
		Pattern pattern3 = Pattern.compile(regex1);
		Matcher matcher3 = pattern3.matcher(name);
		if (matcher3.matches())
			b1 = true;
		return b1;
	}
	public Boolean isValidCity(String city) {
		Boolean b1 = false;
		Pattern pattern4 = Pattern.compile(regex1);
		Matcher matcher4 = pattern4.matcher(city);
		if (matcher4.matches())
			b1 = true;
		return b1;
	}
	public Boolean isValidEmail(String email) {
		Boolean b1 = false;
		String regex5 = "^[A-Za-z0-9+_.-]+@(.+)$";
		Pattern pattern5 = Pattern.compile(regex5);
		Matcher matcher5 = pattern5.matcher(email);
		if (matcher5.matches())
			b1 = true;
		return b1;
	}
	public Boolean isValidPhoneNumber(String number) {
		Boolean b1 = false;
		String regex6 = "[0-9]{10}";
		Pattern pattern6 = Pattern.compile(regex6);
		Matcher matcher6 = pattern6.matcher(number);
		if (matcher6.matches())
			b1 = true;
		return b1;
	}
	public Boolean isValidMovie(String movie) {
		Boolean b1 = false;
		Pattern pattern7 = Pattern.compile(regex1);
		Matcher matcher7 = pattern7.matcher(movie);
		if (matcher7.matches())
			b1 = true;
		return b1;
	}
	public Boolean isValidTheater(String theater) {
		Boolean b1 = false;
		Pattern pattern8 = Pattern.compile(regex1);
		Matcher matcher8 = pattern8.matcher(theater);
		if (matcher8.matches())
			b1 = true;
		return b1;
	}
}
