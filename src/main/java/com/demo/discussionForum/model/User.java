package com.demo.discussionForum.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.time.LocalDate;
import java.util.Set;

@Entity(name = "users")
public class User {
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

    public User(Long id, @Size(min = 4, max = 20) String username, @NotNull String password, @Email String email,
			@Size(max = 30) String firstName, @Size(max = 30) String lastName, @NotNull Boolean isActive,
			String avatarUrl, @NotNull LocalDate dateOfSignUp, @NotNull Set<Role> roles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.isActive = isActive;
		this.avatarUrl = avatarUrl;
		this.dateOfSignUp = dateOfSignUp;
		this.roles = roles;
	}

	@Id
    @GeneratedValue
    private Long id;

	@Column(unique = true)
    @Size(min = 4, max = 20)
    private String username;
	
	@NotNull
    private String password;

    @Column(unique = true)
    @Email
    private String email;

    @Size(max = 30)
    private String firstName;

    @Size(max = 30)
    private String lastName;

    @NotNull
    private Boolean isActive = true;

    private String avatarUrl;

    @NotNull
    private LocalDate dateOfSignUp = LocalDate.now();

    @NotNull
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES", joinColumns = {
            @JoinColumn(name = "USER_ID")}, inverseJoinColumns = {
            @JoinColumn(name = "ROLE_ID")})
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
