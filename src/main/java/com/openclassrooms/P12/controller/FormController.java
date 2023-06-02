package com.openclassrooms.P12.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import com.openclassrooms.P12.service.UserService;


@Controller
public class FormController {



	@Autowired
	private UserService userService;

	private final Logger logger = LoggerFactory.getLogger(FormController.class);



}
