package com.HRManagementSystem.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Employee class that represents the data model
 * for the employee entity/table  in the postgreSQL DB 
 * 
 * @author Roman Nikolov
 *
 */
@Entity
@Table(name = "employees")
public class Employee {

	// All members/columns of the Employee entity  
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Temporal(TemporalType.DATE)
    Date publicationDate;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email_address", nullable = false, unique = true)
	private String email;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "city")
	private String city; 
	
	@Column(name = "postcode")
	private int postcode;
	
	@Column(name = "telephone")
	private long telephone;
	
	@Column(name = "salary")
	private int salary;
	
	/**
	 * Default constructor for the employee class
	 */
	public Employee() {}
	
	
	/**
	 * Overloaded constructor for the Employee class
	 * 
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param telephone
	 * @param address
	 * @param country
	 * @param city
	 * @param postcode
	 * @param salary
	 */
	public Employee(String firstName, String lastName, String email, long telephone,
					String address, String country, String city, int postcode, int salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.address = country;
		this.city = city;
		this.postcode = postcode;
		this.telephone = telephone;
		this.salary = salary;
		
	}
	
	// Following are all getters and setters for the entity members
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPostcode() {
		return postcode;
	}

	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}

	public long getTelephone() {
		return telephone;
	}

	public void setTelephone(long telephone) {
		this.telephone = telephone;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ "]";
	}
	
}