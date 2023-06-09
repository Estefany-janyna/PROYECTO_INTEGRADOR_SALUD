package com.tecsup.RegisterReserva.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class User {
	@Id
	@Column(name="user_id",length = 45)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int user;
	
	@Column(name="user_name",length = 255)
	private String user_name;
	
	@Column(name="email",length = 255)
	private String email;
	
	@Column(name="password", length = 255)
	private String password;

	public User(int user, String user_name, String email, String password) {
		super();
		this.user = user;
		this.user_name = user_name;
		this.email = email;
		this.password = password;
	}

	public User() {
		
	}

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [user=" + user + 
				", user_name=" + user_name + 
				", email=" + email +
				", password=" + password + "]";
	}
	
	
	
	
	

}
