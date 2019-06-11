package com.loginpoc.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loginpoc.model.User;
import com.loginpoc.service.UserService;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@RestController
@RequestMapping("loginpoc")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {
	
	@Autowired
	UserService userService;
	
	Logger logger = LogManager.getLogger(UserController.class);

	@GetMapping(path="users", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getUsers(){
		
	    logger.debug("UserController >>> getUsers ############ START");

		List<User> userList = userService.getAllUsers();
		
		logger.debug("UserController >>> getUsers ############ END");
		
		return new ResponseEntity<List<User>>(userList,HttpStatus.OK);
	}

}
