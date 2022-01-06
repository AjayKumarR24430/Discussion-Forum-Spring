package com.demo.discussionForum.model;


public class LoginUser {

    public LoginUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	private String username;

    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	private String password;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
