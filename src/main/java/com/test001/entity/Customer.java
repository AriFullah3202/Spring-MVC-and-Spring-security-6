package com.test001.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long user_id;
	@NotBlank(message = "your username can not be blank")
	private String user_name;
	@NotEmpty(message = "your password can not be empty")
	private String password;
	private String role;
	@NotEmpty(message = "your email can not be empty")
	private String email;
	
	private Boolean enable;
	
	
	
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getEnable() {
		return enable;
	}
	public void setEnable(Boolean enable) {
		this.enable = enable;
	}
	public Customer(long user_id, String user_name, String password, String role, String email, Boolean enable) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.password = password;
		this.role = role;
		this.email = email;
		this.enable = enable;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Customer [user_id=" + user_id + ", user_name=" + user_name + ", password=" + password + ", role=" + role
				+ ", email=" + email + ", enable=" + enable + "]";
	}
	
	
	

}
