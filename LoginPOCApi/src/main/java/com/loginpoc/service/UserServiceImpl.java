package com.loginpoc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.loginpoc.model.User;
import com.loginpoc.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	@Cacheable("users")
	public List<User> getAllUsers() {

		List<User> userList = userRepository.findAll();
		
		return userList;
	}

	@Override
	public User getUserByUserNameAndPassword(String userName, String password) {

		return userRepository.findByUserNameAndPassword(userName, password);
	}

}
