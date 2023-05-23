package com.employee.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

	@Entity
	@Table(name = "users")
	public class Employee {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;
		
		@Column(name = "first_name",length = 125,nullable = false)
	    private String firstname;
		
		@Column(name = "last_name",length = 125,nullable = false)
	    private String lastname;
		
		@Column(name = "email",length = 125,nullable = false,unique = true)
	    private String email;
		
		@Column(name = "mobile")
	    private String mobile;
		
		public Employee() {
			
		}
     	public Employee(String firstname, String lastname, String email, String mobile) {
			this.firstname = firstname;
			this.lastname = lastname;
			this.email = email;
			this.mobile = mobile;
		}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}