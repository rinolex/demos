package com.HRManagementSystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.HRManagementSystem.model.User;

/**
 * Repository interface based for the User model
 * 
 * @author Roman Nikolov
 *
 */
public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByUserName(String userName);
	User findByUserNameAndPassword(String userName, char[] password);
}
