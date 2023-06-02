package com.openclassrooms.P12.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.openclassrooms.P12.dto.UserDtoDS;
import com.openclassrooms.P12.dto.UserRegistrationDto;

import com.openclassrooms.P12.service.UserService;

@Controller
@RequestMapping("/sInscrire")
public class RegistrateUserController {
	@Autowired
	UserDtoDS userDtoDS;
	@Autowired
    UserService userService;
	private final Logger logger = LoggerFactory.getLogger(FormController.class);

		
	public RegistrateUserController(UserDtoDS userDtoDS) {
		super();
		this.userDtoDS = userDtoDS;
	}

	@ModelAttribute("dicoUser")
	public UserRegistrationDto dicoUserRegistrationDto() {
		return new UserRegistrationDto();
	}
 
	@GetMapping
	public String showRegistrationForm (){
		logger.info("HTTP GET request received at /sInscrire in showRegistrationOrIdentificationForm");
		return "sInscrire";
	}
	
	@PostMapping
	public String dicoUserRegistrationFormSubmit(@Validated @ModelAttribute("dicoUser") UserRegistrationDto dicoUserDto, BindingResult bindingResult) {
		logger.info("HTTP POST request received at /sInscrire in dicoUserRegistrationFormSubmit");
		if (bindingResult.hasErrors()) {
			logger.info("HTTP POST request received at /sInscrire in dicoUserRegistrationFormSubmit in binding has errors");
			return "sInscrire";
		} else if(userService.emailAlreadyExists(dicoUserDto)) {
			logger.info("HTTP POST request received at /sInscrire in dicoUserRegistrationFormSubmit in emailAlreadyExists");
			return "sInscrire";
		}
		
		
		else {
			userDtoDS.save(dicoUserDto);
		}
		return "redirect:/identification"; 
	}
	
}
