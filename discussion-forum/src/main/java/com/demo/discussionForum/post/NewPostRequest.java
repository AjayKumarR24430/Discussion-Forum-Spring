package com.demo.discussionForum.post;

import javax.validation.constraints.Size;


public class NewPostRequest {
    
    @Size(min = 3, message = "{Size.Post.content.validation}")
    private String content;
    
    private String name;
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    public NewPostRequest() {
    	
    }
    
}
