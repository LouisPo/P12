package com.openclassrooms.P12.controller;

import com.openclassrooms.P12.entities.DicoUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.openclassrooms.P12.service.UserService;

@Controller
public class IdentificateAccountController {
	@Autowired
    UserService userService;

	private final Logger logger = LoggerFactory.getLogger(FormController.class);
	private UserDetails userDetails;
	private DicoUser currentDicoUser;
	private ModelAndView mav;
	
	private void UserAuthentication(Authentication authentication) {
		userDetails = (UserDetails) authentication.getPrincipal();
		logger.info("userDetails" + userDetails.getUsername());
		currentDicoUser = userService.findDicoUserByEmail(userDetails.getUsername());
		logger.info("currentDicoUser"+ currentDicoUser.getFirstName());
	}
	
	@RequestMapping(value ="/identification",method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView showLoginForm() {
		logger.info("HTTP GET request received at /identification in showLoginForm");
		mav = new ModelAndView("identification");
		return mav;
	} 
	
	@RequestMapping(value ="/monCompte",method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView showDicoUserInfos (Authentication authentication, ModelMap modelMap) {
		logger.info("HTTP GET request received at /monCompte in showDicoUserInfos");
		UserAuthentication(authentication);
		modelMap.addAttribute("userDetails", userDetails);
		modelMap.addAttribute("currentDicoUser", currentDicoUser);
		mav = new ModelAndView("monCompte");
		return mav;
		
	}
	@RequestMapping(value ="/modifierMonCompte",method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView editDicoUserInfos(Model model) {
		logger.info("HTTP GET request received at /monCompte in editDicoUserInfos");
		model.addAttribute("userDetails", userDetails);
		model.addAttribute("currentDicoUser", currentDicoUser);
		mav = new ModelAndView("modifierMonCompte");
		return mav;
	}

	
	@RequestMapping(value ="/modifierMonCompteInfosPerso",method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView editDicoUserInfos(String firstName, String lastName, String address, String phone) {
		logger.info("HTTP POST request received at /monCompte in editDicoUserInfos");
		userService.DicoUserInfosModification(currentDicoUser,firstName,lastName,address,phone);
		mav = new ModelAndView("redirect:/monCompte");
		return mav;
	}
	
	@RequestMapping(value ="/modifierMonMotDePasse",method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView editDicoUserPassword(String password) {
		logger.info("HTTP POST request received at /monCompte in editDicoUserInfos");
		userService.DicoUserPasswordModification(currentDicoUser, password);
		mav = new ModelAndView("redirect:/monCompte");
		return mav;
	}
	
	@RequestMapping(value ="/modifierMonAdresseEmail",method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView editDicoUserEmail(Authentication authentication,String email) {
		logger.info("HTTP POST request received at /monCompte in editDicoUserInfos");
		UserAuthentication(authentication);
		userService.DicoUserEmailModification(currentDicoUser, email);
		mav = new ModelAndView("redirect:/logout");
		return mav;
	}
	

	
}
