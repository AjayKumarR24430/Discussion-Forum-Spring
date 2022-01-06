package com.demo.discussionForum.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Role {

    public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(long id, @NotNull String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@NotNull
    private String name;

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}