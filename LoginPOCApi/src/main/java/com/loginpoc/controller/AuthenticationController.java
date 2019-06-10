package com.loginpoc.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loginpoc.exception.LoginPOCException;
import com.loginpoc.model.User;
import com.loginpoc.service.UserService;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@RestController
@RequestMapping("loginpoc/authenticate")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthenticationController {

	@Autowired
	UserService userService;
	
	Logger logger = LogManager.getLogger(AuthenticationController.class);

	@PostMapping
	public ResponseEntity<User> aunthenticateLogin(@RequestBody User loginUser) {

		logger.debug("AuthenticationController >>> aunthenticateLogin ############ START");
		
		User currentUser = userService.getUserByUserNameAndPassword(loginUser.getUserName(), loginUser.getPassword());
		HttpStatus httpStatus = HttpStatus.OK;
		
		if (null == currentUser) {
			
			logger.debug("AuthenticationController >>> aunthenticateLogin ############ USER NOT FOUND");
			
			throw new LoginPOCException("User not found, please register to continue" + loginUser.getUserName());
		}
		
		if(null != currentUser && StringUtils.isEmpty(currentUser.getToken())){
			
			logger.debug("AuthenticationController >>> aunthenticateLogin ############ USER TOKE NOT FOUND");
			
			throw new LoginPOCException("User deails are not valid. Authorization token not generated.");
		}

		logger.debug("AuthenticationController >>> aunthenticateLogin ############ END");
		
		return new ResponseEntity<User>(currentUser, httpStatus);
	}

	/*@ExceptionHandler({ LoginPOCException.class })
    public ErrorModel handleException() {
		
		
		
		return null;
    }*/
	
}
