package com.demo.discussionForum.user;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

@Entity
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 893284018826505486L;
    
    public User() {
		// TODO Auto-generated constructor stub
	}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(length = 30, nullable = false, unique = true)
    private String username;

    @Column(length = 60, nullable = false)
    private String password;

    private boolean active;

    private boolean removed;

    private Date createdAt;

    private Date lastLoginTime;

    private Gender gender;

    private Role role;

    @PrePersist
    protected void onCreate() {
        this.setCreatedAt(new Date());
    }

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isRemoved() {
		return removed;
	}

	public void setRemoved(boolean removed) {
		this.removed = removed;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	public String getEmail() {
		return email;
	}
	
	public int getId() {
		return id;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getUsername() {
		return username;
	}
	
    public void setEmail(String email) {
		this.email = email;
	}
    
    public void setId(int id) {
		this.id = id;
	}
    
    public void setPassword(String password) {
		this.password = password;
	}
    
    public void setUsername(String username) {
		this.username = username;
	}
    
    
}
