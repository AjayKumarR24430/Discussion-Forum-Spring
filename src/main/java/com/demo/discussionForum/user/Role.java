package com.demo.discussionForum.user;

public enum Role {

    UNDEFINED("UNDEFINED"),
    USER("USER"),
    ADMIN("ADMIN");

    private String name;

    Role(String name) {
        this.setName(name);
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
