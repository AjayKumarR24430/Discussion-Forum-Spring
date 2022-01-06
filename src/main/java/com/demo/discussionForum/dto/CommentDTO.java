package com.demo.discussionForum.dto;

import com.demo.discussionForum.model.Post;
import com.demo.discussionForum.model.User;
import java.time.LocalDateTime;

public class CommentDTO {
    public CommentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommentDTO(Long id, String content, LocalDateTime dateTimeOfComment, User user, Post post) {
		super();
		this.id = id;
		this.content = content;
		this.dateTimeOfComment = dateTimeOfComment;
		this.user = user;
		this.post = post;
	}

	private Long id;
    
    private String content;

    private LocalDateTime dateTimeOfComment;

    private User user;

    private Post post;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

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

