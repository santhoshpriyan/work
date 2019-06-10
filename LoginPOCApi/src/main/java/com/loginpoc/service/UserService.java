/**
 * 
 */
package com.loginpoc.service;

import java.util.List;

import com.loginpoc.model.User;

/**
 * @author Santhosh
 *
 */
public interface UserService {
	
	List<User> getAllUsers();
	
	User getUserByUserNameAndPassword(String userName, String password);

}
