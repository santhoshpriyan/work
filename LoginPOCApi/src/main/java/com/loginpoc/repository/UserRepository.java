package com.loginpoc.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.loginpoc.model.User;


@Transactional
public interface UserRepository extends JpaRepository<User, Long>{

	User findByUserNameAndPassword(String userName, String password);
	
}


