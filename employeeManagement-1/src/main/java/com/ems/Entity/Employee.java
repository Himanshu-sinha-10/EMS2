package com.ems.Entity;





import java.time.LocalDate;

import javax.persistence.Entity;

import javax.persistence.*;

@Entity
@Table(name = "Employee")
public class Employee {

	@Id
	@GeneratedValue
	private int userId;
	private String firstName;
	private String lastName;
	private LocalDate dob;
	private String email;

	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "emp_dept_id", referencedColumnName = "deparId")
	private Department department;


	
	
	
	public Employee() {
		super();
	
	}



	public Employee( String firstName, String lastName, LocalDate dob, String email,  Department department) {
		super();

		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.email = email;
		this.department = department;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Department getDepartment() {
		return department;
	}

	public void setEmp_dept_id(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
				+ ", email=" + email + ", department=" + department + "]";
	}

}


