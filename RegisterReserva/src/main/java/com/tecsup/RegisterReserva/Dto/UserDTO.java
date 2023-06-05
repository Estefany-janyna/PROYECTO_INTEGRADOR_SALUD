package com.tecsup.RegisterReserva.Dto;

public class UserDTO {
	private int userid;
	private String user_name;
	private String email;
	private String password;
	
	public UserDTO(int userid, String user_name, String email, String password) {
		this.userid = userid;
		this.user_name = user_name;
		this.email = email;
		this.password = password;
	}

	public UserDTO() {
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
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
		return "UserDTO [userid=" + userid +
				", user_name=" + user_name + 
				", email=" + email + 
				", password=" + password
				+ "]";
	}
	
	

}
