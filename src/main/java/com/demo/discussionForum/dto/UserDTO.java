package com.demo.discussionForum.dto;

import com.demo.discussionForum.model.Role;

import java.time.LocalDate;
import java.util.Set;

public class UserDTO {
    public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDTO(Long id, String username, String email, String firstName, String lastName, Boolean isActive,
			String avatarUrl, LocalDate dateOfSignUp, Set<Role> roles) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.isActive = isActive;
		this.avatarUrl = avatarUrl;
		this.dateOfSignUp = dateOfSignUp;
		this.roles = roles;
	}

	private Long id;
    
    private String username;

    private String email;

    private String firstName;

    private String lastName;

    private Boolean isActive;

    private String avatarUrl;

    private LocalDate dateOfSignUp;

    private Set<Role> roles;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public LocalDate getDateOfSignUp() {
		return dateOfSignUp;
	}

	public void setDateOfSignUp(LocalDate dateOfSignUp) {
		this.dateOfSignUp = dateOfSignUp;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
