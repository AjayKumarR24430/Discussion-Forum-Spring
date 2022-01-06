package com.demo.discussionForum.model;

public class AuthToken {

    public AuthToken() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthToken(String token) {
		super();
		this.token = token;
	}

	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}