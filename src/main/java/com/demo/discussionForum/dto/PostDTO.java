package com.demo.discussionForum.dto;

import com.demo.discussionForum.commons.Category;

import java.time.LocalDateTime;
import java.util.Collection;


public class PostDTO {
    public PostDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PostDTO(Long id, String title, String content, LocalDateTime dateTimeOfPost, String imageUrl,
			Collection<Category> categories, Integer ratingPoints, UserDTO user) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.dateTimeOfPost = dateTimeOfPost;
		this.imageUrl = imageUrl;
		this.categories = categories;
		this.ratingPoints = ratingPoints;
		this.user = user;
	}

	private Long id;
    
	private String title;

    private String content;

    private LocalDateTime dateTimeOfPost;

    private String imageUrl;

    private Collection<Category> categories;

    private Integer ratingPoints;

    private UserDTO user;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getDateTimeOfPost() {
		return dateTimeOfPost;
	}

	public void setDateTimeOfPost(LocalDateTime dateTimeOfPost) {
		this.dateTimeOfPost = dateTimeOfPost;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Collection<Category> getCategories() {
		return categories;
	}

	public void setCategories(Collection<Category> categories) {
		this.categories = categories;
	}

	public Integer getRatingPoints() {
		return ratingPoints;
	}

	public void setRatingPoints(Integer ratingPoints) {
		this.ratingPoints = ratingPoints;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

}