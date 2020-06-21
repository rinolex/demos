package com.HRManagementSystem.service;

import com.HRManagementSystem.model.User;

public interface UserServices {
	User saveUser(User user);
	User findByUserNameAndPassword(String userName, char[] password);
}
