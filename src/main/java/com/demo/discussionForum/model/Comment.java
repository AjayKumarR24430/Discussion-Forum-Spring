package com.demo.discussionForum.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Comment {

    public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comment(Long id, @NotNull @Size(min = 2, max = 500) String content, @NotNull LocalDateTime dateTimeOfComment,
			@NotNull User user, @NotNull Post post) {
		super();
		this.id = id;
		this.content = content;
		this.dateTimeOfComment = dateTimeOfComment;
		this.user = user;
		this.post = post;
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

	@NotNull
    @Size(min = 2, max = 500)
    @Column(columnDefinition = "TEXT")
    private String content;

    public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@NotNull
    private LocalDateTime dateTimeOfComment = LocalDateTime.now();

    @NotNull
    @ManyToOne
    private User user;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Post post;
    
	public LocalDateTime getDateTimeOfComment() {
		return dateTimeOfComment;
	}

	public void setDateTimeOfComment(LocalDateTime dateTimeOfComment) {
		this.dateTimeOfComment = dateTimeOfComment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
}
