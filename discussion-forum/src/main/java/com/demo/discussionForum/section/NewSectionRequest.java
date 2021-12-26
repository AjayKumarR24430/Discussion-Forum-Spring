package com.demo.discussionForum.section;

import javax.validation.constraints.Size;


public class NewSectionRequest {
    
    @Size(min = 1, max = 50, message = "{Size.Section.type.validation}")
    private String name;
    
    @Size(max = 300)
    private String description;
    
    public NewSectionRequest() {}
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
}
