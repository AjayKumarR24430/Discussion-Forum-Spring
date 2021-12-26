package com.demo.discussionForum.section;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.discussionForum.section.Section;


public interface SectionRepository extends JpaRepository<Section, Integer> {
    
    Section findByName(String name);
    
}
