package com.HRManagementSystem.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User class that represents the data model
 * for the site's users in the postgreSQL DB 
 * 
 * @author Roman Nikolov
 *
 */
@Entity
@Table(name = "users")
public class User {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "user_name", nullable = false, unique = true)
	private String userName;

	@Column(name = "password", nullable = false, unique = true)
	private char[] password;
	
	@Column(name = "active")
	private boolean active;
	
	@Column(name = "user_role")
	private String userRole;
	
	// Constructors for the User class
	public User() {}
	
	
	public User(String userName, char[] password, boolean active, String userRole) {
		super();
		this.userName = userName;
		this.password = password;
		
		if(active) {
			this.active = active;
		} else {
			this.active = true;
		}
		
		if(userRole != null) {
			this.userRole = userRole;
		} else {
			this.userRole = "ROLE_USER";
		}
	}

	// Getters and Setters for the User entity members
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}
	
	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	public String getUserRole() {
		return userRole;
	}


	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	// Overriding equals() and hashCode() functions
	// to prevent duplicates in Hibernate's cashes - memory leaks
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result + Arrays.hashCode(password);
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((userRole == null) ? 0 : userRole.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (active != other.active)
			return false;
		if (id != other.id)
			return false;
		if (!Arrays.equals(password, other.password))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userRole == null) {
			if (other.userRole != null)
				return false;
		} else if (!userRole.equals(other.userRole))
			return false;
		return true;
	}
}
