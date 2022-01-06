package com.demo.discussionForum.model;

import com.demo.discussionForum.commons.Category;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Indexed
public class Post {

    public Post() {
		super();
	}

	public Post(Long id, @NotNull @Size(min = 3, max = 40) String title,
			@NotNull @Size(min = 5, max = 5000) String content, @NotNull LocalDateTime dateTimeOfPost, String imageUrl,
			Collection<Category> categories, @NotNull @Min(0) Integer ratingPoints, @NotNull User user) {
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

	@Id
    @GeneratedValue
    private Long id;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Field
    @NotNull
    @Size(min = 3, max = 40)
    private String title;

    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Field
    @NotNull
    @Size(min = 5, max = 5000)
    @Column(columnDefinition = "TEXT")
    private String content;

    public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@NotNull
    private LocalDateTime dateTimeOfPost = LocalDateTime.now();

    public LocalDateTime getDateTimeOfPost() {
		return dateTimeOfPost;
	}

	public void setDateTimeOfPost(LocalDateTime dateTimeOfPost) {
		this.dateTimeOfPost = dateTimeOfPost;
	}

	private String imageUrl;

    public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@ElementCollection
    private Collection<Category> categories;

    public Collection<Category> getCategories() {
		return categories;
	}

	public void setCategories(Collection<Category> categories) {
		this.categories = categories;
	}

	@NotNull
    @Min(0)
    private Integer ratingPoints;

    public Integer getRatingPoints() {
		return ratingPoints;
	}

	public void setRatingPoints(Integer ratingPoints) {
		this.ratingPoints = ratingPoints;
	}

	@NotNull
    @ManyToOne()
    private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}