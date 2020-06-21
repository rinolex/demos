package com.HRManagementSystem.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HRManagementSystem.model.User;
import com.HRManagementSystem.repository.UserRepository;

@Service
@Transactional
public class UserServicesImpl implements UserServices {
	@Autowired
	UserRepository userRepository;
	
	/**
	 * Saves a newly created user into the DB
	 * 
	 * @param User entry
	 */
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	 
	/**
	 * Checks if a user exists by given userName and password
	 * 
	 * @param userName String
	 * @param char[] password
	 */
	@Override
	public User findByUserNameAndPassword(String userName, char[] password) {
		return userRepository.findByUserNameAndPassword(userName, password);
	}

}
